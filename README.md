# CerisaieEJB

# Config
importer la bd dans le fichier dans le dossier doc 'cerisaie.sql'
changer standalone.xml dans wildfly par celui dans doc.
Enlever dans les librairies de l'artifact la libraire "Maven: dom4j:dom4j:1.6.1"
Renommer le war "Cerisaie"

# Debug
Si problème Hibernet -> drop database et réimporter la db
Si problème JMS -> remplacer standalone.xml dans wildfy/standlone/configuration/ par celui dans la doc
