package lotto.model;

import java.util.Set;

public class WinnerNumbers {
    private final Set<PositiveNumber> numbers;
    private final BonusBall bonusBall;

    public WinnerNumbers(LottoNumbers numbers, BonusBall bonusBall) {
        validateDuplicate(numbers, bonusBall);
        this.numbers = numbers.lottoNumbers();
        this.bonusBall = bonusBall;
    }

    public boolean has(PositiveNumber number) {
        return numbers.stream()
                .anyMatch(positiveNumber -> positiveNumber.number() == number.number());
    }

    public boolean correctBonus(PositiveNumber number) {
        return number.equals(bonusBall.bonus());
    }

    private void validateDuplicate(LottoNumbers numbers, BonusBall bonusBall) {
        if (numbers.lottoNumbers().contains(bonusBall.bonus())) {
            throw new IllegalArgumentException("보너스 볼이 당첨 번호와 중복됩니다. 보너스볼 : " + bonusBall.number());
        }
    }
}
