# Blackjack Java Application Game

## Description
Develop a Java application that plays the game of Blackjack (aka “21”).  The computer is the dealer, and there can be up to 3 other players.

Requirements/Details:

1.            A simple textual command-line interface for input/output is fine (nothing graphical needed).

2.            Hence the 3 other players can be the same person sitting at the command line, playing three hands.

3.            There is no need to implement hand-splitting (when one has a pair) or any other complex rules.  The simple case of getting cards, trying to get as close to 21 but not being over is sufficient.

4.            Players are dealt cards, and can receive another (hit) or stop receiving cards (stand).  If they go over 21, they are busted.

5.            Cards have numeric value, with face cards are value 10.  An ace is either 1 or 11 to be used to best advantage (highest total without busting 21).

6.            Dealer then receives cards and hits or stands based on some strategy.

7.            Scoring:

a.            If Dealer has more than 21, dealer is busted, and players not busted win.

b.            If Dealer has 21 or less, then players closer to 21 beat dealer, and dealer beats players with same score or less (tie goes to dealer).

8.            Make the dealer’s (computer’s) strategy flexible – it is not important to have a winning strategy, but rather to be able to illustrate how you would flexible change the strategy if asked to.

9.            Provide unit testing where it appropriately adds value – don’t over test, don’t under test.

Use whatever Java classes you want.  Emphasize effective design principles, patterns, and decisions.  Provide comments if there is something you want to describe about why you choose to design/implement something a certain way.  When done check your code into github and email us the link. Feel free to contact us if you need additional information.

 

Note:  Just a word of caution we do check for plagiarism, so we encourage the candidates to not copy solutions off the internet. Inspiration is fine, but please do not submit copied solutions. Thank you.

Example interaction at the command line:

./blackjack 3

Starting game with 3 players.

Shuffling.

Dealing to player 1, card: 2 Hearts

Dealing to player 2, card: 9 Spades

Dealing to player 3, card: 10 Clubs

Dealing to computer, card:  face down

Dealing to player 1, cards: 2 Hearts, 5 Spades.  Hit or Stand? > hit

Dealing to player 1, cards: 2 Hearts, 5 Spades, 10 Hearts.  Hit or Stand? > stand

Dealing to player 2, cards: 9 Spades, 4 Clubs.  Hit or Stand? > hit

Dealing to player 2, cards: 9 Spades, 4 Clubs, 9 Diamonds.  Busted over 21.

Dealing to player 3, cards: 10 Clubs, 10 Diamonds.  Hit or Stand? > stand

Dealing to computer, cards: 5 Hearts, 8 Hearts.  Dealer hits.

Dealing to computer, cards: Ace Hearts, 8 Hearts, 9 Hearts.  Dealer stands.

Scoring player 1 has 17, dealer has 18.  Dealer wins.

Scoring player 2 busted.  Dealer wins.

Scoring player 3 has 20, dealer has 18.  Player 3 wins.
