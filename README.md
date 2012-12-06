# techprobono

Over the last few years, technical people have developed a very fine and noble sense of community. Great strides have been taken to make our profession a more tolerant, open and respectful place. Contributions to this community include developing open source software, tools and libraries, organising conferences and meetups, giving our time up to train the next generation of developers, designers and tech writers, or campaigning for equality and respect amongst all people of technology.

The community now is in a wonderful place, and this work will continue, improving the lot for all of us.

Now that we are getting our own house in order, it is time to look at our role in the greater communities in which we live.

We are a fortunate bunch. We earn far above the national averages of our countries, with considerably better working conditions and opportunities.

This puts us in an enviable position of privilege and comfort. But it also gives us a wonderful opportunity to be able to give something back.  Wouldn't it be great if, along with our CVs and linked in profiles, we included our list of Good Works in our sense of identity?

TechProBono attempts to match geeks with charities, clubs, the next generation of sporting heros, animal shelters, hospitals, schools, good causes and individuals with a technical need, but no finance.

We invite the Good Causes to outline their plans and their motivations here, and to make a case for their need. Perhaps you already have a static website and you would like a simple form to allow your guests to get in touch with you more easily.
Maybe you are a small family-run charity with your base firmly in the spare room and you feel that you need a more up-to-date look and feel – perhaps there is a designer out there who likes your cause and would be willing to make you a professionally designed logo.

## Setup

You can run this application on your local machine. Here are the steps:

### 0. Prerequisites (Mac)

```bash
brew install postgresql
```
Postgresql is a database. You may ask "why not MySQL?". Well, Heroku supports postgresql and it's kind of nice to stay compatible with them.

```bash
brew install foreman
```
Foreman is a tool for running applications via `Procfile` definitions. We will be using it to run a local database server and the techprobono application itself.

```bash
brew install leiningen --devel
```
Leiningen is a tool that makes it easy to set up Clojure applications with all their dependencies.

### 1. Create a database
From the root of this repo, run this:
```bash
initdb data
```
This creates a `data` directory with a bunch of postgresql stuff which will be ignored by git.
Start up a database server in a separate terminal:
```bash
foreman start db
```
Then, back in the previous terminal, create a database like so:
```bash
createdb techprobono
```
Then, unless you want to do some more things with the database right away, stop the database server to free up the port.

### 2. Configure
```bash
cp .env.example .env
```
Edit the file `.env` and adjust the `DATABASE_URL` depending on your database user settings. This is the configuration parameter your local techprobono instance will use to connect to your local database server.

### 3. Run
```bash
foreman start
```
This will start two processes in parallel: a database and an application process.

Go to your browser and open [http://localhost:3000](http://localhost:3000) and it should show the techprobono home page.

### 4. Create schema
```bash
foreman run lein run -m techprobono.schema
```
