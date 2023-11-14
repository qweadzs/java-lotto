package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class LottoOutput {
    private LottoOutput() {

    }

    public static void viewLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void viewLottoDetail(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void viewLottoTotal() {

    }
}