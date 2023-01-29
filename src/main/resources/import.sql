-- COMPANIES
INSERT INTO companies (id, business_name, cuit, created_at) VALUES ('d668fc1a-2a31-4e0e-bcb0-cd55638ee527', 'Santander', '3050120845', '2023-01-27T12:00:31.175586');
INSERT INTO companies (id, business_name, cuit, created_at) VALUES ('3ea0a4d9-fbfc-4a88-aabf-ae65330208d4', 'Banco Nación', '305032845', '2022-11-27T12:00:31.175586');
INSERT INTO companies (id, business_name, cuit, created_at) VALUES ('3ea0a4d9-fbfc-4a88-aabf-ae65330208d5', 'Interbanking', '3023000845', '2019-11-27T12:00:31.175586');

-- TRANSFERENCE
INSERT INTO transferences (id, amount, company_id, credit_account, debit_account, created_at) VALUES ('f7fcecb1-1744-4ff8-b2fb-e39f44c2c9d5', 230500.60, 'd668fc1a-2a31-4e0e-bcb0-cd55638ee527', 46548, null, '2023-01-27T12:00:31.175586');
INSERT INTO transferences (id, amount, company_id, credit_account, debit_account, created_at) VALUES ('9d0fec38-5b9c-4c4d-ba84-5a08b88ff732', 223500.35, 'd668fc1a-2a31-4e0e-bcb0-cd55638ee527', 18002, null, '2023-01-27T12:00:31.175586');
INSERT INTO transferences (id, amount, company_id, credit_account, debit_account, created_at) VALUES ('b3027633-ee18-49d2-934e-4afc66b1449f', 163500.35, 'd668fc1a-2a31-4e0e-bcb0-cd55638ee527', null, 15938, '2023-01-27T12:00:31.175586');
INSERT INTO transferences (id, amount, company_id, credit_account, debit_account, created_at) VALUES ('33adee0b-d40f-4eed-909f-b23736265cc4', 293500.35, '3ea0a4d9-fbfc-4a88-aabf-ae65330208d4', 14038, null, '2022-10-27T12:00:31.175586');
INSERT INTO transferences (id, amount, company_id, credit_account, debit_account, created_at) VALUES ('33adee0b-d40f-4eed-909f-b23736265cc3', 303500.35, '3ea0a4d9-fbfc-4a88-aabf-ae65330208d4', null, 23554, '2023-01-27T12:00:31.175586');
