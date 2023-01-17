import util.Style;

import java.io.*;
import java.util.Scanner;

class FileConverter implements Converter<String>{

    @Override
    public void convert(String source, String destination, Style style) throws IOException {
        File dir = new File(source);
        File[] files=dir.listFiles();
        for(File file:files){
            try(Scanner scanner = new Scanner(file);
                FileWriter fileWriter = new FileWriter(destination+"\\"+file.getName())){
                while(scanner.hasNextLine()){
                    char[] line = scanner.nextLine().toCharArray();
                    for(int i=0;i<line.length;i++){
                        switch (style){
                            case INITCAP:
                                if(line[i]>96 && line[i]<123 && (i==0 || line[i-1]==' ')){
                                    line[i]-=32;
                                }break;
                            case UPPERCASE:
                                if(line[i]>96 && line[i]<123) {
                                    line[i]-=32;
                                }break;
                            case LOWERCASE:
                                if(line[i]>64 && line[i]<91) {
                                    line[i]+=32;
                                }break;
                            case LASTCAP:
                                if(i+1< line.length && (line[i+1]==' ' || line[i+1]=='.') && line[i]>96 && line[i]<123) {
                                    line[i]-=32;
                                }break;
                        }

                    }
                    System.out.println(line);
                    fileWriter.write(String.valueOf(line)+"\n");

                }
            }catch(FileNotFoundException fex){
                System.out.println("File/Directory is missing.");
            }
        }

    }

}