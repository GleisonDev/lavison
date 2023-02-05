CREATE TABLE agents (
	"id" SERIAL NOT NULL PRIMARY KEY,
	"name" text NOT NULL,
	login text NOT NULL UNIQUE,
	"password" text NOT NULL,
	phone text NOT NULL,
	email text NOT NULL,
	acess text NOT NULL
);



