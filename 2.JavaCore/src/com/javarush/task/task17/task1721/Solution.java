package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            reader.close();

            readFileData(fileName1, allLines);
            readFileData(fileName2, forRemoveLines);

            new Solution().joinData();
        }
        catch(CorruptedDataException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void joinData() throws IOException {
        if(containAll(allLines, forRemoveLines)) {
            removeLines(allLines, forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }

    private static void readFileData(String sourceFileName, List<String> recipient) {

        try(BufferedReader fileReader = new BufferedReader(new FileReader(new File(sourceFileName)))) {

            while(fileReader.ready()) {
                recipient.add(fileReader.readLine());
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean containAll(List<String> whoContainsList, List<String> whatContainsList) {
        boolean result = true;

        for(String s : whatContainsList) {
            if(!whoContainsList.contains(s)) {
                result = false;
                break;
            }
        }

        return result;
    }

    private static void removeLines(List<String> whereRemoveList, List<String> whatRemoveList) {
        for(String s : whatRemoveList) {
            whereRemoveList.remove(s);
        }
    }
}
