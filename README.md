# Java Random Insecurity Demonstration: Guessing Game and Seed Predictor
This repository contains a Java project that illustrates the insecurity of using java.util.Random with a fixed or predictable seed. The project includes two programs:

Random_insecure: A number-guessing game where the random numbers are generated using a fixed seed.
SeedPredictor: A tool that demonstrates how, given a few numbers from the guessing game, the seed used to generate them can be predicted, revealing future random numbers.
Purpose
The project showcases a security flaw in java.util.Random when used with fixed or easily predictable seeds. This is critical for understanding why SecureRandom should be used for cryptographic or security-sensitive applications.

How It Works
1. The Guessing Game (Random_insecure)
A simple number-guessing game where the program:
Uses java.util.Random seeded with a constant value (12L by default).
Generates a random number between 0 and 20 for the user to guess.
Awards gold for correct guesses and allows the user to replay.
The seed remains constant throughout the game, making the sequence of numbers predictable.
2. The Seed Predictor (SeedPredictor)
Given a small set of random numbers from the guessing game, the predictor:
Iterates over all possible seeds.
Matches the known numbers against those generated with each seed.
Reveals the seed used by the game.
Prints the next 10 random numbers the game will generate.
Prerequisites
Ensure that you have:

Java Development Kit (JDK) installed.
A Java IDE or the ability to run Java files from the command line.
Usage
Clone the Repository
bash

git clone https://github.com/your-username/repo-name.git
cd repo-name
Compile the Java Files
bash

javac Random_insecure.java SeedPredictor.java
Run the Guessing Game
bash

java Random_insecure
Instructions:
Guess the number between 0 and 20.
Earn gold for correct guesses.
Replay as many times as you like.
Note the numbers generated by the game.
Predict the Seed
bash

java SeedPredictor
Instructions:
Replace the knownNumbers array in SeedPredictor with numbers from the guessing game.
Run the program to find the seed and the next numbers the game will generate.
Example Output
Guessing Game (Random_insecure)


Welcome to the Guessing Game!
I've selected a number between 0 and 20. Can you guess it?
Enter your guess (between 0 and 20): 5
Too low. Try again!
Enter your guess (between 0 and 20): 10
Congratulations! You guessed the number in 2 attempts.
You earned 10 gold! Total gold: 10.
Do you want to play again? (yes/no): no
Seed Predictor (SeedPredictor)


Predicted seed: 12
First 10 numbers generated:
6
14
13
10
7
12
8
3
11
19
Project Structure
Files
Random_insecure.java:

Implements the guessing game.
Uses java.util.Random with a fixed seed for number generation.
SeedPredictor.java:

Predicts the seed based on known random numbers.
Outputs the next numbers generated by the same seed.
Security Insights
Why java.util.Random is Insecure:
The random number generator (RNG) is deterministic when seeded with a known value.
Predicting the seed allows an attacker to determine future RNG outputs, leading to vulnerabilities in games, tokens, or cryptographic systems using this RNG.
When to Use SecureRandom:
Use SecureRandom in security-sensitive contexts as it provides cryptographically strong random values.
Limitations and Future Improvements
Seed Search Performance:

The current implementation searches sequentially from 0 to Long.MAX_VALUE, which may take a long time. Optimizations or parallel processing could improve this.
Game Enhancements:

Introduce variable difficulty levels or improve gameplay features.
Security Education:

Expand documentation to include more real-world examples of RNG vulnerabilities.
Disclaimer
This project is intended for educational purposes only. Do not use insecure random number generators for sensitive or security-critical applications.

