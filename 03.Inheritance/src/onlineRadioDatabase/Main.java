package onlineRadioDatabase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SongDatabase songDatabase = new SongDatabase();

        int n = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < n; i++){
           String[] tokens = scanner.nextLine().split(";");
            String artistName = tokens[0];
            String songName = tokens[1];
            String duration = tokens[2];
            try {
                Song song = new Song(artistName, songName, duration);
                songDatabase.addSong(song);
                System.out.println("Song added.");
            } catch (InvalidSongException ise) {
                System.out.println(ise.getMessage());
            }
        }

        System.out.println(songDatabase);
    }
}
