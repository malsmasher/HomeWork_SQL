package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private final SelenideElement codeField = $("[data-test-id='code'] input");
    private final SelenideElement button = $("[data-test-id='action-verify']");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification'] .notification__content");

    public VerificationPage() {
        codeField.shouldBe(visible);
    }

    public DashboardPage validCode(String verificationCode) {
        virify(verificationCode);
        return new DashboardPage();
    }

    public void virify(String verificatinCode) {
        codeField.setValue(verificatinCode);
        button.click();
    }

    public void errorMessage(String expectedText) {
        errorNotification.shouldHave(exactText(expectedText))
                .shouldBe(visible, Duration.ofSeconds(15));
    }

}