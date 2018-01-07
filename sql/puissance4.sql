/*drop table puissance4;*/
create table if not exists 
	puissance4 ( id int primary key  ,joueur1 varchar(45),joueur2 varchar(45),joueurActuel varchar(45),gagnant varchar(45),partie varchar(45) array [41]);
