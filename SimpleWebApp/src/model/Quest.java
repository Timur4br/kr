package model;

import javax.persistence.*;
import java.security.Timestamp;

@Entity
@Table(name = "quests")
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questId")
    private int questId;

    @Column(name = "questTitle")
    private String questTitle;

    @Column(name = "questText")
    private String questText;

    @Column(name = "personId")
    private String personId;

    @Column(name = "reward")
    private int reward;

    @Column(name = "penalty")
    private int penalty;

    @Column(name = "timeOfStarted")
    private Timestamp timeOfStarted;

    @Column(name = "timeForQuestInMinutes")
    private int timeForQuestInMinutes;

    @Column(name = "placeId")
    private String placeId;

    @Column(name = "modelId")
    private String modelId;

    @Column(name = "levelDifficulty")
    private int levelDifficulty;

    @Enumerated(EnumType.STRING)
    @Column(name = "questStatus")
    private QuestStatus questStatus;

    // Constructors, getters, and setters
    // Конструкторы, геттеры и сеттеры

    public enum QuestStatus {
        CREATED, ASSIGNED, STARTED, FOR_CHECK, SUCCESS, FAILED
    }

    // Constructors
    public Quest() {
    }

    public Quest(String questTitle, String questText, String personId, int reward, int penalty, Timestamp timeOfStarted,
                 int timeForQuestInMinutes, String placeId, String modelId, int levelDifficulty, QuestStatus questStatus,
                 int questId) {
        this.questTitle = questTitle;
        this.questText = questText;
        this.personId = personId;
        this.reward = reward;
        this.penalty = penalty;
        this.timeOfStarted = timeOfStarted;
        this.timeForQuestInMinutes = timeForQuestInMinutes;
        this.placeId = placeId;
        this.modelId = modelId;
        this.levelDifficulty = levelDifficulty;
        this.questStatus = questStatus;
        this.questId = questId;
    }

    // Getters and Setters
    public int getQuestId() {
        return questId;
    }

    public void setQuestId(int questId) {
        this.questId = questId;
    }

    public String getQuestTitle() {
        return questTitle;
    }

    public void setQuestTitle(String questTitle) {
        this.questTitle = questTitle;
    }

    public String getQuestText() {
        return questText;
    }

    public void setQuestText(String questText) {
        this.questText = questText;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public Timestamp getTimeOfStarted() {
        return timeOfStarted;
    }

    public void setTimeOfStarted(Timestamp timeOfStarted) {
        this.timeOfStarted = timeOfStarted;
    }

    public int getTimeForQuestInMinutes() {
        return timeForQuestInMinutes;
    }

    public void setTimeForQuestInMinutes(int timeForQuestInMinutes) {
        this.timeForQuestInMinutes = timeForQuestInMinutes;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public int getLevelDifficulty() {
        return levelDifficulty;
    }

    public void setLevelDifficulty(int levelDifficulty) {
        this.levelDifficulty = levelDifficulty;
    }

    public QuestStatus getQuestStatus() {
        return questStatus;
    }

    public void setQuestStatus(QuestStatus questStatus) {
        this.questStatus = questStatus;
    }
}