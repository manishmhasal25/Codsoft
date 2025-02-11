import java.util.*;

class QuizApp {
    private static int score = 0;
    private static int questionIndex = 0;
    private static boolean answered = false;
    private static Timer timer;

    private static String[][] questions = {
         {"Who is the main protagonist of Panchayat?", "Abhishek Tripathi", "Vikas", "Rinki", "Prahlad", "1"},
        {"Which village is the setting for Panchayat?", "Fakauli", "Phulera", "Pipra", "Sultanpur", "2"},
        {"Who plays the role of the village Pradhan?", "Neena Gupta", "Raghubir Yadav", "Jitendra Kumar", "Biswapati Sarkar", "1"},
        {"What is Abhishek Tripathi’s profession?", "Teacher", "Doctor", "Panchayat Secretary", "Shopkeeper", "3"},
        {"Which streaming platform hosts Panchayat?", "Netflix", "Disney+ Hotstar", "Amazon Prime Video", "Sony LIV", "3"},
        {"Who composed the music for Panchayat?", "Amit Trivedi", "Anurag Saikia", "Pritam", "AR Rahman", "2"},
        {"Which year was Panchayat first released?", "2019", "2020", "2021", "2022", "2"},
        {"What is Abhishek’s aim alongside his job?", "Start a business", "Prepare for CAT", "Prepare for UPSC", "Settle in the village", "3"},
        {"Which character is known for his comic timing and loyalty?", "Vikas", "Rinki", "MLA", "Sarpanch", "1"},
        {"Who directed the series Panchayat?", "Deepak Kumar Mishra", "Raj Nidimoru", "Krishna DK", "Pankaj TripatBBhi", "1"}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (questionIndex = 0; questionIndex < questions.length; questionIndex++) {
            answered = false;
            startTimer();
            
            System.out.println((questionIndex + 1) + ". " + questions[questionIndex][0]);
            for (int j = 1; j <= 4; j++) {
                System.out.println(j + ") " + questions[questionIndex][j]);
            }
            
            int answer = sc.nextInt();
            checkAnswer(answer);
            timer.cancel();
        }
        
        System.out.println("Quiz Over! Your final score: " + score + "/10");
        
    }

    private static void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            
            public void run() {
                if (!answered) {
                    System.out.println("Time's up! Moving to the next question.");
                    questionIndex++;
                    answered = true;
                }
            }
        }, 100000);
    }

    private static void checkAnswer(int answer) {
        answered = true;
        if (String.valueOf(answer).equals(questions[questionIndex][5])) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Wrong! Correct answer was: " + questions[questionIndex][Integer.parseInt(questions[questionIndex][5])]);
        }
    }
}

