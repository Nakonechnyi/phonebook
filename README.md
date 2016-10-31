Choose DB by VM argument -Ddb_type=MONGO_DB or -Ddb_type=MY_SQL

Create MySQL tables:

            CREATE SCHEMA `phonebook` ;

            CREATE TABLE `phonebook`.`users` (
              `id` MEDIUMINT(18) NOT NULL AUTO_INCREMENT,
              `pib` VARCHAR(45) NOT NULL,
              `login` VARCHAR(45) NOT NULL,
              `password` VARCHAR(255) NOT NULL,
              PRIMARY KEY (`id`),
              UNIQUE INDEX `id_UNIQUE` (`id` ASC));

            CREATE TABLE `phonebook`.`contacts` (
              `id` MEDIUMINT(18) NOT NULL AUTO_INCREMENT,
              `owner` MEDIUMINT(18) NOT NULL,
              `last_name` VARCHAR(45) NOT NULL,
              `first_name` VARCHAR(45) NOT NULL,
              `surname` VARCHAR(45) NOT NULL,
              `phone` VARCHAR(45) NOT NULL,
              `home_phone` VARCHAR(45) NULL,
              `address` VARCHAR(45) NULL,
              `email` VARCHAR(45) NULL,
              PRIMARY KEY (`id`),
              UNIQUE INDEX `id_UNIQUE` (`id` ASC),
              INDEX `owner_idx` (`owner` ASC),
              CONSTRAINT `owner`
                FOREIGN KEY (`owner`)
                REFERENCES `phonebook`.`users` (`id`)
                ON DELETE NO ACTION
                ON UPDATE NO ACTION);


Create mongoDB tables:

            db.createCollection("users")
            db.createCollection("contacts")


On basic /index page login and registration

After login you will get HAL browser with Spring HATEOAS resources.
Links you get are only about yours contacts.
Create new by GET method (yes it's temporary bag about custom non-GET pages for HAL).
Also, there are methods to search with filters...
Inside each contact you can Update, Delete by non-Get button.

DBases use separated models because of ORM conflicts.

One, but nice test example about Resources testing.
Need more for safe continuous.

One interesting bug:
    Security Principal is accessible directly:
        SecurityContextHolder.getContext().getAuthentication().getPrincipal()
    but not accessible in SpEL:
        #{principal.username}
