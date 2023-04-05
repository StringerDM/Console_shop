package stream_api_task.common;

import java.util.Scanner;

public class PageLoop {
    final private AppView view;

    public PageLoop(AppView view) {
        this.view = view;
    }

    int getChildrenSize() {
        return view.getChildren().size();
    }

    int getOptionalSize() {
        int optionalSize = 0;
        if (view.hasNextPage) {
            optionalSize++;
        }
        optionalSize += view.availableComparators.size();
        return optionalSize;
    }

    public void run() {
        while (true) {
            view.action();
            display();
            final int fullSize = getChildrenSize() + getOptionalSize() + 1;
            Scanner in = new Scanner(System.in);
            int value = in.nextInt();
            if (value < 0 || value > fullSize) {
                System.out.println("Неверное значение страницы");
            }
            else if (value == fullSize) {
                break;
            } else if (value <= getChildrenSize()) {
                AppView selectedView = view.getChildren().get(value - 1);
                new PageLoop(selectedView).run();
            } else {
                if (value - 1 == getChildrenSize() && view.hasNextPage) {
                    view.nowPage++;
                    new PageLoop(view).run();
                } else {
                    view.nowPage = 0;
                    int comparatorIndex = value - getChildrenSize() - 1 - (view.hasNextPage ? 1 : 0);
                    view.selectedComparator = view.availableComparators.get(comparatorIndex);
                    new PageLoop(view).run();
                }
            }
        }
    }

    public void display() {
        int currentIndex = 1;
        System.out.println(view.getTitle());
        System.out.println("Выберите пункт меню (1 - " + (getChildrenSize() + getOptionalSize() + 1) + ")");
        for (int i = 0; i < getChildrenSize(); i++) {
            AppView appView = view.getChildren().get(i);
            System.out.println(currentIndex + " - " + appView.getTitle());
            currentIndex++;
        }
        if (view.hasNextPage) {
            System.out.println(currentIndex + " - " + "Следующая страница");
            currentIndex++;
        }
        for (int i = 0; i < view.availableComparators.size(); i++) {
            System.out.println(currentIndex + " - " + view.availableComparators.get(i).name);
            currentIndex++;
        }
        System.out.println(currentIndex + " - назад");
    }
}
