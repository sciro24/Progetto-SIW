-- Inserimento Utente
insert into utente(id, cognome, email, nome) values (nextval('utente_seq'), 'Scirocco', 'diego.scirocco@gmail.com', 'Diego');
insert into utente(id, cognome, email, nome) values (nextval('utente_seq'), 'Marconi','marco.marconi@gmail.com' , 'Marco');
insert into utente(id, cognome, email, nome) values (nextval('utente_seq'), 'Macale', 'andriu.macale@hotmail.com', 'Andrea');


-- Inserimento Credenziali
insert into credenziali(id, password, role, username, utente_id) values (nextval('credenziali_seq'), '$2a$10$p6sFaE0TOXvkmrOUXjdFXuiCq7HkALiEwi1KVhhmqyYZvefF3lE7K', 'ADMIN', 'Diego', (select id from utente where email = 'diego.scirocco@gmail.com'));
insert into credenziali(id, password, role, username, utente_id) values (nextval('credenziali_seq'), '$2a$10$36fHPrcZ5kjTLgxtbB8FdeL5ETeDyCBDSvIKbI7n6AJbqs/c4flmS', 'DEFAULT', 'Marco', (select id from utente where email = 'marco.marconi@gmail.com'));
insert into credenziali(id, password, role, username, utente_id) values (nextval('credenziali_seq'), '$2a$10$S6HueP.58CzXZhQtat/sGOHgpoRSDpYQ835AA3Gq1Pu2dOijVLzCS', 'DEFAULT', 'Andrea', (select id from utente where email = 'andriu.macale@hotmail.com')); 


-- Inserimento Ricette
insert into ricetta(id, descrizione, nome, tempo_preparazione, url_of_picture) values (nextval('ricetta_seq'), 'Cuoci la pasta in acqua salata. In una padella, scalda olio e aggiungi pomodori pelati schiacciati. Cuoci fino a ottenere una salsa densa. Mescola con la pasta cotta e servi.', 'Pasta al Pomodoro', 30, 'https://www.giallozafferano.it/images/221-22163/Spaghetti-al-pomodoro_450x300.jpg');
insert into ricetta(id, descrizione, nome, tempo_preparazione, url_of_picture) values (nextval('ricetta_seq'), 'Soffriggi cipolla in burro, aggiungi riso e tosta per alcuni minuti. Versa brodo caldo poco alla volta fino a cottura completa. Aggiungi funghi trifolati e parmigiano. Mescola e servi caldo.', 'Risotto ai Funghi', 45, '');
insert into ricetta(id, descrizione, nome, tempo_preparazione, url_of_picture) values (nextval('ricetta_seq'), 'Prepara una base con pomodoro e mozzarella su pasta per pizza. Cuoci in forno fino a doratura. Aggiungi basilico fresco prima di servire.', 'Pizza Margherita', 60, '');
insert into ricetta(id, descrizione, nome, tempo_preparazione, url_of_picture) values (nextval('ricetta_seq'), 'Cuoci pasta in acqua salata. In una padella, rosola pancetta, aggiungi uova sbattute e pecorino. Mescola con pasta cotta, crea una crema senza cuocere troppo.', 'Pasta alla Carbonara', 25, '');
insert into ricetta(id, descrizione, nome, tempo_preparazione, url_of_picture) values (nextval('ricetta_seq'), 'Rosola guanciale in padella. Aggiungi pomodoro e cuoci fino a ridurre. Mescola con pasta cotta e pecorino. Servi con pepe nero a piacere.', 'Pasta Amatriciana', 35, '');
insert into ricetta(id, descrizione, nome, tempo_preparazione, url_of_picture) values (nextval('ricetta_seq'), 'Cuoci pasta e scolala. In una padella, sciogli pecorino con un po’ di acqua di cottura. Aggiungi pepe macinato e mescola con pasta.', 'Cacio e Pepe', 20, '');


-- Inserimento Ingredienti
insert into ingrediente(id, nome, vegano) values(nextval('ingrediente_seq'), 'Pomodoro', true);
insert into ingrediente(id, nome, vegano) values(nextval('ingrediente_seq'), 'Basilico', true);
insert into ingrediente(id, nome, vegano) values(nextval('ingrediente_seq'), 'Mozzarella', false);
insert into ingrediente(id, nome, vegano) values(nextval('ingrediente_seq'), 'Funghi', true);
insert into ingrediente(id, nome, vegano) values(nextval('ingrediente_seq'), 'Riso', true);
insert into ingrediente(id, nome, vegano) values(nextval('ingrediente_seq'), 'Pasta', true);
insert into ingrediente(id, nome, vegano) values(nextval('ingrediente_seq'), 'Uova', false);
insert into ingrediente(id, nome, vegano) values(nextval('ingrediente_seq'), 'Pancetta', false);
insert into ingrediente(id, nome, vegano) values(nextval('ingrediente_seq'), 'Pecorino', false);
insert into ingrediente(id, nome, vegano) values(nextval('ingrediente_seq'), 'Guanciale', false);
insert into ingrediente(id, nome, vegano) values(nextval('ingrediente_seq'), 'Pepe', true);


-- Inserimento Relazioni Ricetta-Ingredienti
insert into ricetta_ingredienti(composizioni_id, ingredienti_id) values (1, 1); -- Pasta al Pomodoro -> Pomodoro
insert into ricetta_ingredienti(composizioni_id, ingredienti_id) values (1, 2); -- Pasta al Pomodoro -> Basilico
insert into ricetta_ingredienti(composizioni_id, ingredienti_id) values (1, 6); -- Pasta al Pomodoro -> Pasta
insert into ricetta_ingredienti(composizioni_id, ingredienti_id) values (2, 4); -- Risotto ai Funghi -> Funghi
insert into ricetta_ingredienti(composizioni_id, ingredienti_id) values (2, 5); -- Risotto ai Funghi -> Riso
insert into ricetta_ingredienti(composizioni_id, ingredienti_id) values (3, 1); -- Pizza Margherita -> Pomodoro
insert into ricetta_ingredienti(composizioni_id, ingredienti_id) values (3, 2); -- Pizza Margherita -> Basilico
insert into ricetta_ingredienti(composizioni_id, ingredienti_id) values (3, 3); -- Pizza Margherita -> Mozzarella
insert into ricetta_ingredienti(composizioni_id, ingredienti_id) values (4, 6); -- Pasta
insert into ricetta_ingredienti(composizioni_id, ingredienti_id) values (4, 7); -- Uova
insert into ricetta_ingredienti(composizioni_id, ingredienti_id) values (4, 8); -- Pancetta
insert into ricetta_ingredienti(composizioni_id, ingredienti_id) values (4, 9); -- Pecorino
insert into ricetta_ingredienti(composizioni_id, ingredienti_id) values (5, 6); -- Pasta
insert into ricetta_ingredienti(composizioni_id, ingredienti_id) values (5, 10); -- Guanciale
insert into ricetta_ingredienti(composizioni_id, ingredienti_id) values (5, 1); -- Pomodoro
insert into ricetta_ingredienti(composizioni_id, ingredienti_id) values (5, 9); -- Pecorino
insert into ricetta_ingredienti(composizioni_id, ingredienti_id) values (6, 6); -- Pasta
insert into ricetta_ingredienti(composizioni_id, ingredienti_id) values (6, 9); -- Pecorino
insert into ricetta_ingredienti(composizioni_id, ingredienti_id) values (6, 11); -- Pepe


-- Inserimento Recensioni 
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (nextval('recensione_seq'), 'Deliziosa! Facile da fare e molto gustosa.', 5, 1, 1);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (nextval('recensione_seq'), 'Il risotto era perfetto, cremoso e saporito.', 4, 2, 2);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (nextval('recensione_seq'), 'La pizza era buona, ma poteva essere più croccante.', 3, 3, 1);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (nextval('recensione_seq'), 'Carbonara spettacolare, una delle migliori che abbia mai mangiato.', 5, 4, 2);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (nextval('recensione_seq'), 'Ottima Amatriciana, il guanciale era perfetto.', 4, 5, 3);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (nextval('recensione_seq'), 'Cacio e Pepe molto buono, semplice e gustoso.', 4, 6, 1);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (nextval('recensione_seq'), 'La pasta al pomodoro era deliziosa e molto facile da fare.', 5, 1, 2);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (nextval('recensione_seq'), 'Il risotto ai funghi era troppo cremoso per i miei gusti.', 3, 2, 3);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (nextval('recensione_seq'), 'Pizza Margherita buona, ma la base era un po morbida.', 3, 3, 2);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (nextval('recensione_seq'), 'Carbonara con troppa pancetta, ma comunque buona.', 3, 4, 1);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (nextval('recensione_seq'), 'Amatriciana favolosa, la migliore che abbia mai mangiato.', 5, 5, 1);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (nextval('recensione_seq'), 'Cacio e Pepe perfetto, la cremosità era giusta.', 5, 6, 2);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (nextval('recensione_seq'), 'La pasta al pomodoro era troppo semplice per i miei gusti.', 3, 1, 3);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (nextval('recensione_seq'), 'Il risotto ai funghi aveva un sapore fantastico.', 5, 2, 1);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (nextval('recensione_seq'), 'Pizza Margherita con ottimo equilibrio di ingredienti.', 4, 3, 3);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (nextval('recensione_seq'), 'La Carbonara era un po secca.', 2, 4, 3);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (nextval('recensione_seq'), 'Amatriciana troppo salata per i miei gusti.', 2, 5, 2);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (nextval('recensione_seq'), 'Cacio e Pepe con troppo pepe.', 2, 6, 3);



