# CerisaieEJB

# Config
importer la bd dans le fichier dans le dossier doc 'cerisaie.sql'
changer standalone.xml dans wildfly par celui dans doc.
Enlever dans les librairies de l'artifact la libraire "Maven: dom4j:dom4j:1.6.1"
Renommer le war "Cerisaie"

# Debug
Si problème Hibernet -> drop database et réimporter la db
Si problème JMS -> remplacer standalone.xml dans wildfy/standlone/configuration/ par celui dans la doc
Si problème "File not found" pour l'artifact ou autre ->
supprimer dossiers classes + out
supprimer artifact
refaire un artifact exploded  
le nommer Cerisaie
dans la même fenêtre onglet "Output Layout" -> WEB-INF/lib/
Enlever dans la libraire"Maven: dom4j:dom4j:1.6.1"
Checker sa config de run qu'il y ait un artifact de buil
