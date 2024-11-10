# Cucumber-streaming-template

Template de démarrage pour des tests Cucumber, conçu pour automatiser les scénarios de test d'un site de streaming. Ce projet sert de base pour créer et exécuter facilement des tests BDD pour vérifier les fonctionnalités clés d'une plateforme de streaming.

## Structure du Projet

- `src/main/java/com/api/cucumber/featurefile/` : Contient les fichiers `.feature` définissant les scénarios BDD.
- `src/main/java/com/api/cucumber/runner/` : Contient les classes Java pour exécuter les tests correspondants aux fonctionnalités.

## Fonctionnalités

- [LoginFeature](src/main/java/com/api/cucumber/featurefile/LoginFeature.feature) : Scénarios de test pour la fonctionnalité de connexion.
- [PlayFeature](src/main/java/com/api/cucumber/featurefile/PlayFeature.feature) : Scénarios de test pour la fonctionnalité de lecture de contenu.

## Tests

- [UserLogin](src/main/java/com/api/cucumber/runner/UserLogin.java) : Fichier de test pour la fonctionnalité de connexion.
- [PlayRunner](src/main/java/com/api/cucumber/runner/PlayRunner.java) : Fichier de test pour la fonctionnalité de lecture de contenu.

## Prérequis

- **Java 8+** : Assurez-vous que Java est installé et configuré sur votre système.
- **Maven** : Utilisé pour gérer les dépendances du projet.
- **Cucumber** : Pour exécuter les scénarios de test.

## Installation

1. Clonez le projet :
   ```bash
   git clone https://github.com/votre-utilisateur/Cucumber-streaming-template.git

2. installez les dépendances avec Maven:
   ```bash
   mvn clean install

Licence

Ce projet est sous [LICENSE](LICENSE) MIT.
