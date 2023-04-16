package org.client;

import com.google.gson.Gson;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class SingleStudentClient {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();

        String jsonString = gson.toJson(generateRandomStudent());

        Socket connectionSocket = new Socket("localhost", 6789);

        DataOutputStream outToServer = new DataOutputStream(connectionSocket.getOutputStream());
        outToServer.writeBytes(jsonString);

        connectionSocket.close();
    }

    private static List<Exam> generateRandomExamsPool(int poolSize) {
        final String[] examNames =  {   "Analisi 1", "Analisi 2", "Geometria 1", "Geometria 2", "Fisica 1", "Fisica 2",
                "Computer Graphics", "Distributed Systems", "Probabilita' e Statistica"
        };

        List<Exam> examsPool = new ArrayList<>();

        for (int i = 0; i < 200; i ++) {
            Random random = new Random();
            long currentTimeMillis = System.currentTimeMillis();
            long randomTimeMillis = (long) (random.nextDouble() * currentTimeMillis);

            String randomExam = examNames[random.nextInt(examNames.length)];
            int randomMark = random.nextInt(16) + 15;
            Date randomDate = new Date(randomTimeMillis);

            examsPool.add(new Exam(randomExam, randomMark, randomDate));
        }

        return examsPool;
    }

    private static Student generateRandomStudent() {
        final String[] studentNames =   {   "Davide", "Andrea", "Giovanni", "Luca",
                "Francesco", "Giacomo", "Laura", "Sara", "Sofia", "Giovanna",
                "Francesca", "Paola", "Maria", "Giorgia", "Lisa"
        };

        final String[] studentSurnames =   {   "Rossi", "Marcucci", "Paolillo", "Ziani",
                "Gigli", "Andreoli", "Rossi", "Verdi", "Neri", "Mazza",
                "Onofri", "La Manna", "Sto Cazzo", "Aloisi", "Penni"
        };

        final String[] placeOfResidence =   {   "Milano", "Roma", "Forli'", "Cesena",
                "Bologna", "Barcellona", "Como", "Locarno", "Bellinzona", "Torino",
                "Trento", "Treviso", "Aosta", "Cortina", "Udine"
        };

        List<Exam> randomExams = generateRandomExamsPool(10);

        Random random = new Random();
        long currentTimeMillis = System.currentTimeMillis();
        long randomTimeMillis = (long) (random.nextDouble() * currentTimeMillis);

        String randomName = studentNames[random.nextInt(studentNames.length)];
        String randomSurname = studentSurnames[random.nextInt(studentSurnames.length)];
        String randomResidence = placeOfResidence[random.nextInt(placeOfResidence.length)];
        Date randomBirthDate = new Date(randomTimeMillis);

        return new Student(randomName, randomSurname, randomBirthDate, randomResidence, randomExams);
    }
}
