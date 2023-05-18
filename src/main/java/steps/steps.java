package steps;

import pageObject.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import library.BaseSteps;

public class steps extends BaseSteps {
    private BaseSteps base;
    private LoginPage loginpage;
    private CreateSoccerTeam createSoccerTeam;
    private CreateGolfTeam createGolfTeam;
    private AddNewCoach addNewCoach;
    private WriteMessage msgBox;
    private CreateLiveWorkout LiveWork;
    private CreateLiveTraining LiveTrain;
    private CreateLivePrivateWorkout LivePrt;
    private UpdatePlayer Updte;

    public steps(BaseSteps base) {
        this.base = base;
        loginpage = new LoginPage(base.driver);
        createSoccerTeam = new CreateSoccerTeam(base.driver);
        createGolfTeam = new CreateGolfTeam(base.driver);
        addNewCoach = new AddNewCoach(base.driver);
        msgBox = new WriteMessage(base.driver);
        LiveWork = new CreateLiveWorkout(base.driver);
        LiveTrain = new CreateLiveTraining(base.driver);
        LivePrt = new CreateLivePrivateWorkout(base.driver);
        Updte = new UpdatePlayer(base.driver);

    }

    @Given("^I land on entry page$")
    public void iLandOnEntryPage() throws Exception {
        loginpage.navigateTo(config.getHost());
        loginpage.validate_signIn_page();

    }

    @When("I enter email, password and click on enter")
    public void iEnterEmailPasswordAndClickOnSignInButton() {
        loginpage.logInTheForm(config.getUserName(), config.getPassword());
    }

    @Then("^I land on dashboard page$")
    public void iLandOnDashboardPage() {
        loginpage.validate_dashboard_page();
    }

    @When("^I click on Manage Teams on dashboard$")
    public void iClickOnManageTeamsOnDashboard() {
        createSoccerTeam.manageTeams();
    }

    @Then("^I land on Teams Page$")
    public void iLandOnTeamsPage() {
        createSoccerTeam.validate_teams_page();
    }

    @When("^I click on Add new Team$")
    public void iClickOnAddNewTeam() {
        createSoccerTeam.addnewTeam();
    }

    @And("^I type team name on textbox$")
    public void iTypeTeamNameOnTextbox() throws Exception {
        createSoccerTeam.enterteamInfo();
    }
    @And("^I click on golf option$")
    public void iClickOnGolfOption() {
        createGolfTeam.selectGolf();
    }

    @And("^I click on create button$")
    public void iClickOnCreateButton() {
        createSoccerTeam.createteam();
    }


    @When("^I click on eye icon on the team for opening team detail$")
    public void iClickOnEyeIconOnTheTeamForOpeningTeamDetail() {
        addNewCoach.open_team_Detail();
    }

    @And("^I click on add a coach for club$")
    public void iClickOnAddACoachForClub() {
        addNewCoach.addnewCoachtoClub();
    }


    @When("^I enter coach info$")
    public void iEnterCoachInfo() throws InterruptedException {
        addNewCoach.entercoachInfo();
    }

    @And("^I click on add button$")
    public void iClickOnAddButton() {
        addNewCoach.addcoach();
    }

    @When("^I click on message button on the team$")
    public void iClickOnMessageButtonOnTheTeam() {
        msgBox.gotomessageBox();
    }

    @Then("^I land on Messages page$")
    public void iLandOnMessagesPage() {
        msgBox.validateMessages();
    }

    @When("^I type a message on text area$")
    public void iTypeAMessageOnTextArea() {
        msgBox.writeMessage();
    }

    @And("^I click on send button$")
    public void iClickOnSendButton() {
        msgBox.sendMessage();
    }

    @Given("^I click on manage workouts button$")
    public void iClickOnManageWorkoutsButton() {
        LiveWork.openWorkout();
    }

    @Then("^I land on Workouts page$")
    public void iLandOnWorkoutsPage() {
        LiveWork.validate_workouts_page();
    }

    @And("^I click on Create new workout$")
    public void iClickOnCreateNewWorkout() {
        LiveWork.addnewWorkout();
    }

    @And("^I enter workout Info$")
    public void iEnterWorkoutInfo() throws InterruptedException {
        LiveWork.enterWorkoutInfo();
    }

    @And("^I click on continue button$")
    public void iClickOnContinueButton() {

        LiveWork.continueWrk();
    }

    @When("^I click on View Training Plans button$")
    public void iClickOnViewTrainingPlansButton() {
        LiveTrain.viewTrainingPlans();
    }

    @Then("^I land on trainings page$")
    public void iLandOnTrainingsPage() {
        LiveTrain.validate_trainings_page();
    }

    @When("^I click on Add new training button$")
    public void iClickOnAddNewTrainingButton() {
        LiveTrain.addnewTraining();
    }

    @And("^I enter training Info$")
    public void iEnterTrainingInfo() throws InterruptedException {
        LiveTrain.entertrainingInfo();
    }

    @Given("^I click on private workouts menu on the left workouts and lessons menu$")
    public void iClickOnPrivateWorkoutsMenuOnTheLeftWorkoutsAndLessonsMenu() {
        LivePrt.openPrivateWorkout();
    }

    @When("^I land on private workouts page$")
    public void iLandOnPrivateWorkoutsPage() {
        LivePrt.validate_private_workouts_page();
    }

    @Then("^I click on Add new private workout button$")
    public void iClickOnAddNewPrivateWorkoutButton() {
        LivePrt.addnewPrivateWorkout();
    }

    @When("^I enter private workout info$")
    public void iEnterPrivateWorkoutInfo() throws InterruptedException {
        LivePrt.enterPrivateWorkoutInfo();
    }

    @When("^I click on players on the left team management menu$")
    public void iClickOnPlayersOnTheLeftTeamManagementMenu() {
        Updte.openplayers();
    }

    @Then("^I land on players page$")
    public void iLandOnPlayersPage() {
        Updte.validate_players_page();
    }

    @When("^I click on change teams on the player$")
    public void iClickOnChangeTeamsOnThePlayer() {
        Updte.updatePlayer();
    }

    @And("^I select teams on the opened page$")
    public void iSelectTeamsOnTheOpenedPage() throws InterruptedException {
        Updte.selectandunselectTeam();
    }

    @And("^I click on Update button$")
    public void iClickOnUpdateButton() {
        Updte.updateP();
    }
}