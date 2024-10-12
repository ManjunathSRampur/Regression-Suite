import time
import json
import logging
import logging.handlers as handlers
import psycopg2
import string
from datetime import datetime
import sys

config = {
        "host" : "34.159.70.173",
        "port" : "7000",
        "user" : "postgres",
        "passwd" : "0iLj2ojMu1A0n9Gyx5I5mqz1",
        "database": "agam",
        "schema": "bodhee"
}

sslrootcert_path = '.\ca-cert.pem'
sslcert_path = '.\client-cert.pem'
sslkey_path = '.\postgresql-2.pk8'

formatter = logging.Formatter('%(asctime)s %(levelname)s %(message)s')
def setup_logger(name, logfile, level=logging.INFO):
    """Function setup as many loggers as you want"""
    handler = handlers.RotatingFileHandler('.\ct_truncation_log\{}'.format(logfile),maxBytes=2000000, backupCount=5)
    handler.setFormatter(formatter)
    logger = logging.getLogger(name)
    logger.setLevel(level)
    logger.addHandler(handler)
    return logger
super_logger = setup_logger('logger', 'test.log')
super_logger.info('Control Tower truncation script started')

# Database connection
def db_connect():
    global conn
    global cur
    while True:
        try:
            conn = psycopg2.connect(host = config["host"], port=config["port"], database = config["database"], user = config["user"], password = config["passwd"],sslmode='verify-ca',sslrootcert=sslrootcert_path, sslcert=sslcert_path, sslkey=sslkey_path )
            conn.autocommit = False
            cur = conn.cursor()
            super_logger.info('PG DB_CONNECT: Success: {}')
            print("PG DB_CONNECT: Success")
            if conn.closed == 0:
                break
        except (Exception,psycopg2.InterfaceError) as error:
            super_logger.error('PG DB_CONNECTION_FAILED: {}'.format(error))
            super_logger.error('Retry Connecting to DB ')
            time.sleep(5)
            continue

paramet = sys.argv [1]
if paramet == "yes":
    print("Control Tower truncation script triggered")
    db_connect()
elif paramet =="no":
    print("Control Tower truncation script not triggered")
    exit()
else:
    print("Pass a valid argument ['yes' for Control Tower truncation, 'no' for not triggering Control Tower truncation]")
    exit()


try:
    if paramet =="yes":
        sql_query = '''SELECT pg_terminate_backend(pid) FROM pg_stat_activity WHERE pid <> pg_backend_pid()  AND datname = 'agam';
truncate imp.imp_campaign RESTART IDENTITY;
truncate imp.imp_batch RESTART identity cascade;
truncate imp.imp_process_step RESTART IDENTITY;
truncate imp.imp_technical_step RESTART IDENTITY;
truncate imp.imp_assigned_asset RESTART IDENTITY;
truncate imp.imp_assigned_operator RESTART IDENTITY;
truncate maintenance.equipment_downtime RESTART IDENTITY;
truncate maintenance.equipment_downtime_detail RESTART IDENTITY;
truncate team.operator_leave RESTART IDENTITY;
truncate imp.imp_operator_temp_allocation RESTART IDENTITY;
truncate imp.imp_production_delay RESTART IDENTITY;
truncate imp.imp_technical_step_delay RESTART IDENTITY;
truncate imp.imp_shift_handover RESTART identity cascade;
truncate imp.imp_handover_technical_step RESTART IDENTITY;
truncate imp.imp_handover_process_step RESTART IDENTITY;
truncate imp.imp_handover_assigned_asset RESTART IDENTITY;
truncate imp.imp_handover_assigned_operator RESTART IDENTITY;
truncate imp.imp_batch_quality_release_tracker RESTART IDENTITY;
truncate imp.imp_sidetask_assignments RESTART IDENTITY;'''
        super_logger.info("Query : %s",sql_query)
        cur.execute(sql_query)
        super_logger.info("Query Executed")
        print("Query Executed")
        conn.commit()
        time.sleep(1)

except Exception as e:
    super_logger.info("Exception: {}".format(e))
    cur.close()
    conn.close()
    db_connect()

time.sleep(1)
