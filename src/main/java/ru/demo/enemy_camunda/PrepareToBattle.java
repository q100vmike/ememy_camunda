package ru.demo.enemy_camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class PrepareToBattle implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        int warriors = (int) delegateExecution.getVariable("warriors");
        int enemyWarriors = (int) (Math.random() * 100);
        String battleStatus = "Undefined";
        boolean isWin = false;

        if (warriors - enemyWarriors > 0) {
            isWin = true;
            battleStatus = "Victoty!";
        } else {
            battleStatus = "Fail :(";
        }

        delegateExecution.setVariable("battleStatus", battleStatus);
        delegateExecution.setVariable("enemyWarriors", enemyWarriors);
        delegateExecution.setVariable("isWin", isWin);
    }
}