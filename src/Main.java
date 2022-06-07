public class Main {
    public static void main(String[] args) {
        GameProgress save1 = new GameProgress(100, 20,1,20.5);
        GameProgress save2 = new GameProgress(80, 15,2,30.0);
        GameProgress save3 = new GameProgress(70, 12,3,40.2);

        GameProgress.saveGame("E://Idea/Netology//JavaCore//Games//savegames", save1);
        GameProgress.saveGame("E://Idea/Netology//JavaCore//Games//savegames", save2);
        GameProgress.saveGame("E://Idea/Netology//JavaCore//Games//savegames", save3);

//       GameProgress.zipFiles("E://Idea//Netology//JavaCore//Games//savegames//saves.zip");
        ZipArch.zipFiles("E://Idea//Netology//JavaCore//Games//savegames//saves.zip", GameProgress.getSavesPaths());

        GameProgress.deleteSaves();

    }
}