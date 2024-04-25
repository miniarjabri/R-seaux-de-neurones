# R-seaux-de-neurones
Réseau de Neurones en Java
Ce projet Java implémente un réseau de neurones pour effectuer diverses tâches telles que la prédiction du résultat. Le réseau de neurones est conçu pour être flexible et extensible, permettant l'ajout de différentes architectures de réseau et de fonctions d'activation.

Structure du Projet
Le projet est organisé comme suit :

ReseauxDeNeurones : Ce package contient la classes principales pour le réseau de neurones;  la classe ReseauNeurone qui représente le réseau dans son ensemble.
LesCouches : Ce package contient une classe abstraite Couche duquelle les différentes classes couches du réseau, telles que la couche d'entrée, la couche cachée et la couche de sortie.
LesNeurones : Ce package contient une classe abstraite Neuronne duqeulle héritent les différentes classes des types de neurones utilisés dans le réseau, tels que les neurones d'entrée, les neurones cachés et les neurones de sortie.

chaque couche posséde de 1 à plusieurs neuronnes.
un neuronne peut exister sans une couche.
un réseau de neuronne posséde de 2 à plusieurs couches. 
la classe réseau de neuronne posséde une méthode Entrainer() auquel on fait entrer un lot d'échantillon pour entrainer ce réseau, le réseau réglera donc ses poids en fonction de la sortie attendue en utilisant le type de fonction d'activation demandé (sigmoide ou linéaire)
Cette classe posséde également la fonction cout et la fonction rétroprpager qui vont aider à l'entrainement dans la fonction entrainer()


Utilisation
Pour utiliser le réseau de neurones dans votre application Java, suivez ces étapes :

Importez le projet dans votre environnement de développement Java.
Créez une instance de ReseauNeurone en spécifiant le nombre de couches, le nombre de neurones dans chaque couche, les données d'entrée et de sortie, etc.
Entraînez le réseau en appelant la méthode entrainer() avec les données d'entraînement appropriées.
Utilisez le réseau entraîné pour effectuer des prédictions ou des classifications sur de nouvelles données en appelant la méthode propager().
