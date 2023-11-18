package lotto.controller;

import lotto.model.*;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class LottoApplication {
    private final LottoInput lottoInput;
    private final LottoOutput lottoOutput;

    public LottoApplication(LottoInput lottoInput, LottoOutput lottoOutput) {
        this.lottoInput = lottoInput;
        this.lottoOutput = lottoOutput;
    }

    public void run() {
        LottoFactory lottoFactory = new LottoFactory(lottoInput.getInput());
        Lottos lottos = lottoFactory.generateLottos();

        lottoOutput.viewLottoCount(lottos);
        lottoOutput.viewLottosDetail(lottos);

        WinnerNumbers winnerNumbers = new WinnerNumbers(lottoInput.getWinningNumber(), lottoInput.getBonusBall());
        Lottery lottery = new Lottery(winnerNumbers, lottos);

        lottoOutput.viewCorrectLottos(lottery);
        lottoOutput.viewTotalIncomeRatio(lottery);
    }

}