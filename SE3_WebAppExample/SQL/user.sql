
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(50) NOT NULL,
  `LAST_NAME` varchar(50) NOT NULL,
  `USERNAME` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  PRIMARY KEY  (`ID`)
  )

  CREATE TABLE `forum` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(50) NOT NULL,
  `BODY` varchar(500) NOT NULL,
  `CATEGORY` varchar(20) NOT NULL,
  PRIMARY KEY  (`ID`)
  )
  
  INSERT INTO forum VALUES (null, "MyLife", "I walk this lonely road, to find the end has fallen off the earth.. #deep", "Personal"),
  INSERT INTO forum VALUES (null, "Moral Good", " Since Socrates, we have asked the question; How do you define universal 'Good', is there a universal good? What is morality...", "Philosophy")
  INSERT INTO forum VALUES (null, "My Favourite Songs", "Clair de Lune, Burial - Versus, Muse.. ", "Music")
  INSERT INTO forum VALUES (null, "What do you guys think? ", "I have many questions, not many answers.. ", "Other")
  INSERT INTO forum VALUES (null, "A day in the Life of Me", "I woke up this morning..", "Personal")
  INSERT INTO forum VALUES (null, "Worst Overrated Songs", "Justin Bieber, Drake..", "Music")
   

INSERT INTO user VALUES ( null, "Jamal", "Mahmoud", "jamalm", "12081994")
 INSERT INTO user VALUES( null, "Steven", "Donnellan", "shtav", "1234")
 INSERT INTO user VALUES( null, "Sami", "Mahmoud", "samim", "1234")
 INSERT INTO user VALUES( null, "Dermot", "O'Halloran", "dermo", "1234")
  						
 
  