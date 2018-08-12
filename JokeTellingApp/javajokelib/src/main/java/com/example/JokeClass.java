package com.example;

import java.util.Random;

public class JokeClass {

        private static final String[] JokesArray = {
                "Why did the computer go to the doctor? Because it had a virus!",
                "What do you call a computer floating in the ocean? A Dell Rolling in the Deep.",
                "What is written on Steve Jobs tombstone? iCame, iSaw, iConquered, iLeft, iCameBack, iThinkDifferent, iMac, iPod, iTunes, iPhone, iPad, iCloud, iRIP.",
                "Why do Java developers wear glasses? Because they don't C#.",
                "Where did the computer go to dance? To a disc-o.Because it left its windows open.",
                "What is an astronaut's favorite place on a computer? The Space bar! ",
                "What did the dentist say to the computer? This won't hurt a byte.",
                "What type of a computer does a horse like to eat? A Macintosh.",
                "What does a blonde do when her laptop computer freezes? She sticks it in the microwave!",
                "What do you call a woman you married off the internet? Wife-I.",
                "What does a baby computer calls its father? Obsolete.",
                "What do you get if you cross a computer with a ballet dancer? The Netcracker suite.",
                "What does a king computer do? Execute his programs!",
                "Why won't blondes take their iPhones to the bathroom? Because they don't want to give away their IP address!",
                "How do you get a computer drunk? A Screenshot of Tequila.",
                "What part of a computer does a spider use? The webcam.",
                "Why did Jack and Jill really go up the hill? To get better Wi-fi.",
                "What was the spider doing on the computer? Searching the web!",
                "Why can't an elephant use a computer? He's too afraid of the mouse.",
                " What do you get when you cross a hamburger with a computer? A big mac!",
                " How are elephants and computers similar? They both have big memories.",
                "How did the spider destroy the (worldwide) web? It gave it a bug.",
                " Why did Mark Zuckerberg visit Beijing, China? To see the Great Firewall.",
                " Why are PCs like air conditioners? They stop working properly if you open Windows!",
                "What did mommy spider say to baby spider? You spend too much time on the web."
        };

        private static final Random randomGeneratorValue = new Random();

        public String getAllJokes() {
            return JokesArray[randomGeneratorValue.nextInt(JokesArray.length)];
        }

}
