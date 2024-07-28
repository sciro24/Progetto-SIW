-- Inserimento Utente
insert into utente(id, cognome, email, nome) values (nextval('utente_seq'), 'Scirocco', 'diego.scirocco@gmail.com', 'Diego');
insert into utente(id, cognome, email, nome) values (nextval('utente_seq'), 'Marconi','marco.marconi@gmail.com' , 'Marco');
insert into utente(id, cognome, email, nome) values (nextval('utente_seq'), 'Macale', 'andriu.macale@hotmail.com', 'Andrea');


-- Inserimento Credenziali
insert into credenziali(id, password, role, username, utente_id) values (nextval('credenziali_seq'), '$2a$10$p6sFaE0TOXvkmrOUXjdFXuiCq7HkALiEwi1KVhhmqyYZvefF3lE7K', 'ADMIN', 'Diego', (select id from utente where email = 'diego.scirocco@gmail.com'));
insert into credenziali(id, password, role, username, utente_id) values (nextval('credenziali_seq'), '$2a$10$36fHPrcZ5kjTLgxtbB8FdeL5ETeDyCBDSvIKbI7n6AJbqs/c4flmS', 'DEFAULT', 'Marco', (select id from utente where email = 'marco.marconi@gmail.com'));
insert into credenziali(id, password, role, username, utente_id) values (nextval('credenziali_seq'), '$2a$10$S6HueP.58CzXZhQtat/sGOHgpoRSDpYQ835AA3Gq1Pu2dOijVLzCS', 'DEFAULT', 'Andrea', (select id from utente where email = 'andriu.macale@hotmail.com')); 
