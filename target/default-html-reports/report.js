$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/apiTasks.feature");
formatter.feature({
  "name": "Test API",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "5. Task: get/pet/findByStatus Negative Case",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@nur"
    }
  ]
});
formatter.step({
  "name": "send wrong GET request to api and verify status code",
  "keyword": "When "
});
formatter.match({
  "location": "apiTasksStepDef.send_wrong_GET_request_to_api_and_verify_status_code()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "6. Task: post/pet Negative Case",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@nur"
    }
  ]
});
formatter.step({
  "name": "send wrong POST request to api and verify status code",
  "keyword": "When "
});
formatter.match({
  "location": "apiTasksStepDef.send_wrong_POST_request_to_api_and_verify_status_code()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "7. Task: put/user/{username} Negative Case",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@nur"
    }
  ]
});
formatter.step({
  "name": "send wrong PUT request to api and verify status code and updatedID \"100\"",
  "keyword": "When "
});
formatter.match({
  "location": "apiTasksStepDef.send_wrong_PUT_request_to_api_and_verify_status_code_and_updatedID(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "8. Task: delete/user/{username} Negative Case",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@nur"
    }
  ]
});
formatter.step({
  "name": "create user \"williamloves\" via api and send wrong DELETE request to api verify status code",
  "keyword": "Given "
});
formatter.match({
  "location": "apiTasksStepDef.create_user_via_api_and_send_wrong_DELETE_request_to_api_verify_status_code(String)"
});
formatter.result({
  "status": "passed"
});
});