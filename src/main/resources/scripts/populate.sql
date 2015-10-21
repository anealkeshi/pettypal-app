INSERT INTO credential(created_at,created_by,updated_at,updated_by,id,password,username) values(CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP,1,1,'password','user');
INSERT INTO user(created_at,created_by,updated_at,updated_by,id,firstName,lastName,phonenumber,credential_id) values(CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP,1,1,'Anil', 'K C', '6419808654', 1);
