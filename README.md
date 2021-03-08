#Si vous avez un soucis avec le zip voici le git du projet :
##https://github.com/LgAlexHub/ANTLR

#Commandes pour lancer la grammaire depuis mon ordi : 
java org.antlr.v4.Tool *.g4 
javac *.java .\AdresseType.java .\TablesSymboles.java .\TableSymboles.java 
java -cp ".;C:\Users\lib\antlr-4.9-complete.jar" org.antlr.v4.gui.TestRig calcul 'start' 