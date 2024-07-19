-- Inserimento Utente
insert into utente(id, cognome, email, nome) values (1, 'Scirocco', 'diego.scirocco@gmail.com', 'Diego');
insert into utente(id, cognome, email, nome) values (2, 'Marconi','marco.marconi@gmail.com' , 'Marco');
insert into utente(id, cognome, email, nome) values (3, 'Macale', 'andriu.macale@hotmail.com', 'Andrea');



-- Inserimento Credenziali
insert into credenziali(id, password, role, username, utente_id) values (1, '$2a$10$p6sFaE0TOXvkmrOUXjdFXuiCq7HkALiEwi1KVhhmqyYZvefF3lE7K', 'ADMIN', 'Diego', 1);
insert into credenziali(id, password, role, username, utente_id) values (2, '$2a$10$36fHPrcZ5kjTLgxtbB8FdeL5ETeDyCBDSvIKbI7n6AJbqs/c4flmS', 'DEFAULT', 'Marco', 2);
insert into credenziali(id, password, role, username, utente_id) values (3, '$2a$10$S6HueP.58CzXZhQtat/sGOHgpoRSDpYQ835AA3Gq1Pu2dOijVLzCS', 'DEFAULT', 'Andrea', 3); 



-- Inserimento Ricette
insert into ricetta(id, descrizione, nome, tempo_preparazione) values (1, 'Una deliziosa pasta al pomodoro', 'Pasta al Pomodoro', 30);
insert into ricetta(id, descrizione, nome, tempo_preparazione) values (2, 'Risotto cremoso ai funghi', 'Risotto ai Funghi', 45);
insert into ricetta(id, descrizione, nome, tempo_preparazione) values (3, 'Pizza Margherita classica', 'Pizza Margherita', 60);
insert into ricetta(id, descrizione, nome, tempo_preparazione) values (4, 'Una pasta classica romana con uova, pecorino e pancetta', 'Pasta alla Carbonara', 25);
insert into ricetta(id, descrizione, nome, tempo_preparazione) values (5, 'Un piatto saporito con pomodoro, pecorino e guanciale', 'Pasta Amatriciana', 35);
insert into ricetta(id, descrizione, nome, tempo_preparazione) values (6, 'Una pasta semplice con pecorino e pepe', 'Cacio e Pepe', 20);


-- Inserimento Ingredienti
insert into ingrediente(id, nome, vegano) values(1, 'Pomodoro', true);
insert into ingrediente(id, nome, vegano) values(2, 'Basilico', true);
insert into ingrediente(id, nome, vegano) values(3, 'Mozzarella', false);
insert into ingrediente(id, nome, vegano) values(4, 'Funghi', true);
insert into ingrediente(id, nome, vegano) values(5, 'Riso', true);
insert into ingrediente(id, nome, vegano) values(6, 'Pasta', true);
insert into ingrediente(id, nome, vegano) values(7, 'Uova', false);
insert into ingrediente(id, nome, vegano) values(8, 'Pancetta', false);
insert into ingrediente(id, nome, vegano) values(9, 'Pecorino', false);
insert into ingrediente(id, nome, vegano) values(10, 'Guanciale', false);
insert into ingrediente(id, nome, vegano) values(11, 'Pepe', true);



-- Inserimento Recensioni
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (1, 'Deliziosa! Facile da fare e molto gustosa.', 5, 1, 1);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (2, 'Il risotto era perfetto, cremoso e saporito.', 4, 2, 2);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (3, 'La pizza era buona, ma poteva essere più croccante.', 3, 3, 1);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (4, 'Carbonara spettacolare, una delle migliori che abbia mai mangiato.', 5, 4, 2);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (5, 'Ottima Amatriciana, il guanciale era perfetto.', 4, 5, 3);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (6, 'Cacio e Pepe molto buono, semplice e gustoso.', 4, 6, 1);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (7, 'La pasta al pomodoro era deliziosa e molto facile da fare.', 5, 1, 2);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (8, 'Il risotto ai funghi era troppo cremoso per i miei gusti.', 3, 2, 3);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (9, 'Pizza Margherita buona, ma la base era un po morbida.', 3, 3, 2);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (10, 'Carbonara con troppa pancetta, ma comunque buona.', 3, 4, 1);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (11, 'Amatriciana favolosa, la migliore che abbia mai mangiato.', 5, 5, 1);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (12, 'Cacio e Pepe perfetto, la cremosità era giusta.', 5, 6, 2);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (13, 'La pasta al pomodoro era troppo semplice per i miei gusti.', 3, 1, 3);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (14, 'Il risotto ai funghi aveva un sapore fantastico.', 5, 2, 1);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (15, 'Pizza Margherita con ottimo equilibrio di ingredienti.', 4, 3, 3);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (16, 'La Carbonara era un po secca.', 2, 4, 3);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (17, 'Amatriciana troppo salata per i miei gusti.', 2, 5, 2);
insert into recensione(id, commento, voto, ricetta_id, utente_id) values (18, 'Cacio e Pepe con troppo pepe.', 2, 6, 3);


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

