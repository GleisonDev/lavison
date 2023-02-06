CREATE TABLE products (
	"id" SERIAL NOT NULL PRIMARY KEY,
	"name" text NOT NULL,
	brand text NOT NULL,
	"section" text NOT NULL,
	price decimal(8,2),
	"cost" decimal(8,2) NOT NULL,
	"amount" integer,
	active boolean NOT NULL

);
