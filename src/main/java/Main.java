import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App {

    public void run() {

        Scanner scanner = new Scanner(System.in);
        int lastNo = 0;
        WiseSaying[] wiseSayingList = new WiseSaying[3];

        System.out.println("== 명언 앱 ==");
        while(true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if(command.equals("종료")) {
                System.out.println("명언 앱을 종료합니다.");
                break;

            } else if(command.equals("등록")) {

                System.out.print("명언 : ");
                String content = scanner.nextLine(); // 입력값 가져옴. 입력값이 없으면 기다린다. 엔터를 쳐야 입력이 완료됨. 그래야 넘어감

                System.out.print("작가 : ");
                String author = scanner.nextLine();

                WiseSaying wiseSaying = new WiseSaying();

                wiseSaying.id = ++lastNo;
                wiseSaying.content = content;
                wiseSaying.author = author;

                wiseSayingList[lastNo - 1] = wiseSaying;

                System.out.println("%d번 명언이 등록되었습니다.".formatted(lastNo));
            } else if(command.equals("목록")) {

                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for(int i = 0; i < lastNo; i++) {
                    WiseSaying wiseSaying = wiseSayingList[i];
                    System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.author, wiseSaying.content));
                }

//                for(int i = 2; i >= 0; i--) {
//                    System.out.println("%d / %s / %s".formatted(i, authorList[i], authorList[i]));
//                }
            }
        }
    }
}

class WiseSaying {
    int id;
    String content;
    String author;
}
