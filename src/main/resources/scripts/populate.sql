INSERT INTO credential(created_at,created_by,updated_at,updated_by,password,username) values(CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP,1,'password','user');
INSERT INTO credential(created_at,created_by,updated_at,updated_by,password,username) values(CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP,1,'admin','admin');

INSERT INTO user(created_at,created_by,updated_at,updated_by,firstName,lastName,phonenumber,credential_id) values(CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP,1,'Anil', 'K C', '641-9808-654', 1);
INSERT INTO user(created_at,created_by,updated_at,updated_by,firstName,lastName,phonenumber,credential_id) values(CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP,1,'Boldkhuu', 'Dadsas', '641-9808-654', 2);
