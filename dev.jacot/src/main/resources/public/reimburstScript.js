let baseUrl = "http://localhost:8010";


var employeeid = JSON.parse(sessionStorage.getItem("logged in employee"));

async function login() {
    console.log("login button pressed");

    let uname = document.getElementById('uname').value;

    let epass = document.getElementById('epass').value;

    let user = {
        username: uname,
        password: epass
    }

    let employeeJson = JSON.stringify(user);
    console.log(employeeJson);

    let res = await fetch(
                        `${baseUrl}/employeelogin`,
                        {
                            method: 'POST',
                            header: {'Content-Type': 'application/json'},
                            body : employeeJson
                        }
    );

    let resJson = await res.json()

    .then((resp) => {
        window.location.assign("employeehomepage.html");
    })

    .catch((error) => 
    {
        console.log(error);
    });
}

async function managelogin()
{
    console.log("manage log button pressed");

    let mname = document.getElementById('mname').value;

    let mpass = document.getElementById('mpass').value;

    let user = {
        manageUsername : mname,
        managePassword : mpass
    }

    console.log(user);

    let manageJson = JSON.stringify(user);
    console.log(manageJson)

    let res = await fetch(
                    `${baseUrl}/managerlogin`,
                    {
                        method : 'POST',
                        header: {'Content-Type': 'application/json'},
                        body : manageJson
                    }

    );

    let resJson = await res.json()
    .then((resp) => {
        console.log(resp);
        window.location.assign("managerhomepage.html");
    })

    .catch((error) => 
    {
        console.log(error);
    });
}


async function Submit()
{
    console.log("Submission Processing");

    let firstN = document.getElementById('firstN').value;
    let lastName = document.getElementById('lastName').value;
    let date = document.getElementById('date').value;
    let eventTime = document.getElementById('eventTime').value;
    let location = document.getElementById('location').value;
    let select = document.getElementById('select').value;
    let cost = document.getElementById('cost').value;
    let grading = document.getElementById('grading').value;
    let justification = document.getElementById('justification').value;
    let eventDescription = document.getElementById('eventDescription').value;
    let eId = document.getElementById('eId').value;

    let form = 
    {
        eFirstName : firstN,
        eLastName : lastName,
        formDate : date,
        formTime : eventTime,
        eventLocation : location,
        eventType : select,
        eventCost : cost,
        gradeType : grading,
        formJustification : justification,
        eventDescription : eventDescription,
        employeeId : eId
    }

    console.log(form);

    let formJson = JSON.stringify(form);

    console.log(formJson);

    let res = await fetch (
                            `${baseUrl}/employeelogin/submit`,
                            {
                                method : 'POST',
                                header : {'Content-Type': 'application/json'},
                                body : formJson
                            }
    );

    let resJson = await res.json()
    .then((resp) => {
        console.log(resp);
        window.location.assign("employeehomepage.html");
    })

    .catch((error) => 
    {
        console.log(error);
    });


}


async function GradeSubmit()
{
    console.log("Grade Submitted");

    let passorfail = document.getElementById('passorfail').checked;
    let presentation = document.getElementById('presentation').checked;
    let lettergrade = document.getElementById('lettergrade').value;

    console.log(passorfail);

    let grade = {letterGrade : lettergrade,presentation : presentation,passOrFail : passorfail}

    console.log(grade);

    let gradeJson = JSON.stringify(grade);

    console.log(gradeJson);

    let res = await fetch (
        `${baseUrl}/employeelogin/gradesubmit`,
        {
            method : 'POST',
            header : {'Content-Type': 'application/json'},
            body : gradeJson
        }
    );

    let resJson = await res.json()
    .then((resp) => {
        console.log(resp);
        window.location.assign("employeehomepage.html");
    })
    .catch((error) =>
    {
        console.log(error);
    });
}


async function viewAll() {


   let res = await fetch (
        `${baseUrl}/managerlogin/fmrequestform`,
        {
            method : 'GET',
            header : {'Content-Type': 'application/json'},
        }
    );


    let resJson = await res.json()
    .then((resp) => {
        console.log(resp);

        let formDiv = document.getElementById("forms");

    for(let form of resp)
    {

        let formID = document.createElement('h2');
        let firstNameHeader = document.createElement('h2');
        let lastNameHeader = document.createElement('h2');
        let dateform = document.createElement('h2');
        let timeForm = document.createElement('h2');
        let formDescription = document.createElement('h2');
        let formJustification = document.createElement('h2');
        let eventClassification = document.createElement('h2');
        let eID = document.createElement('h2');

        formID.innerHTML = `Form Identification Number : ${form.formId}`;

        firstNameHeader.innerHTML = form.eFirstName;
        firstNameHeader.className = "Classhere";

        lastNameHeader.innerHTML = form.eLastName;
        lastNameHeader.className = "lastName";

        dateform.innerHTML = `date : ${form.formDate}`;

       
        timeForm.innerHTML = `Time : ${form.formTime}`;

        formDescription.innerHTML = `Event Description : ${form.eventDescription}`;
        formJustification.innerHTML = `Event Justification : ${form.formJustification}`;

        eventClassification.innerHTML = `Type of Event : ${form.eventType}`;
        
        eID.innerHTML = `Employee ID : ${form.employeeId}`;

        formDiv.append(formID);
        formDiv.append(firstNameHeader);
        formDiv.append(lastNameHeader);
        formDiv.append(timeForm);
        formDiv.append(dateform);
        formDiv.append(formDescription);
        formDiv.append(formJustification);
        formDiv.append(eventClassification);
        formDiv.append(eID);
    }

    })
    .catch((error) =>
    {
        console.log(error);
    });


}

async function Deny()
{
    let formid = document.getElementById('formId').value;

    console.log(formid);

    let data = {
        formId : formid
    }

    console.log(data);

    let dataJSON = JSON.stringify(data);

    let res = await fetch (
        `${baseUrl}/managerlogin/formdeny`,
        {
            method : 'PUT',
            header : {'Content-Type' : 'application/json'},
            body : dataJSON
        }
    );
    
    console.log(res);

    let resJson = await res.json()
    .then((resp) => {
        console.log(resp);
        window.location.assign("managerhomepage.html");
    })
    .catch((error) =>
    {
        console.log(error);
    });

} 


async function Approve()
{
    let formid = document.getElementById('approveId').value;

    console.log(formid);

    let data = {
        formId : formid
    }

    console.log(data);

    let dataJSON = JSON.stringify(data);

    let res = await fetch (
        `${baseUrl}/managerlogin/formapprove`,
        {
            method : 'PUT',
            header : {'Content-Type' : 'application/json'},
            body : dataJSON
        }
    );
    
    console.log(res);

    let resJson = await res.json()
    .then((resp) => {
        console.log(resp);
        window.location.assign("managerhomepage.html");
    })
    .catch((error) =>
    {
        console.log(error);
    });

}

async function viewAllGrades() {

    let res = await fetch (
         `${baseUrl}/managerlogin/viewgrades`,
         {
             method : 'GET',
             header : {'Content-Type': 'application/json'},
         }
     );
 
 
     let resJson = await res.json()
     .then((resp) => {
         console.log(resp);
 
         let gradeDiv = document.getElementById("grades");
 
     for(let grades of resp)
     {
 
         let gradeID = document.createElement('h2');
         let letterGrade = document.createElement('h2');
         let passorFail = document.createElement('h2');
         let presentationGrade = document.createElement('h2');
 
         gradeID.innerHTML = `Grade Identification Number : ${grades.gradeId}`;

         letterGrade.innerHTML = `Letter Grade : ${grades.letterGrade}`;

         passorFail.innerHTML = `Pass or Fail : ${grades.passOrFail}`;

         presentationGrade.innerHTML = `Presentation : ${grades.presentation}`;
 
         gradeDiv.append(gradeID);
         gradeDiv.append(letterGrade);
         gradeDiv.append(passorFail);
         gradeDiv.append(presentationGrade);
     }
 
     })
     .catch((error) =>
     {
         console.log(error);
     });
 
 
 }




// async function viewStatus()
// {
//     let employID = document.getElementById('employeeID').value;

//     console.log(employID);

//     let data = {
//         employeeId : employID
//     }

//     console.log(data);

//     let res = await fetch (
//         `${baseUrl}/employeelogin/viewforms`,
//         {
//             method : 'GET',
//             header : {'Content-Type' : 'application/json'},
//         }
//     );


//     let resJson = await res.json()
//     .then((resp) => {
//         console.log(resp);

//         let formDiv = document.getElementById("forms");

//     for(let form of resp)
//     {

//         let formID = document.createElement('h2');
//         let firstNameHeader = document.createElement('h2');
//         let lastNameHeader = document.createElement('h2');
//         let dateform = document.createElement('h2');
//         let timeForm = document.createElement('h2');
//         let formDescription = document.createElement('h2');
//         let formJustification = document.createElement('h2');
//         let eventClassification = document.createElement('h2');
//         let eID = document.createElement('h2');

//         formID.innerHTML = `Form Identification Number : ${form.formId}`;

//         firstNameHeader.innerHTML = form.eFirstName;
//         firstNameHeader.className = "Classhere";

//         lastNameHeader.innerHTML = form.eLastName;
//         lastNameHeader.className = "lastName";

//         dateform.innerHTML = `date : ${form.formDate}`;

       
//         timeForm.innerHTML = `Time : ${form.formTime}`;

//         formDescription.innerHTML = `Event Description : ${form.eventDescription}`;
//         formJustification.innerHTML = `Event Justification : ${form.formJustification}`;

//         eventClassification.innerHTML = `Type of Event : ${form.eventType}`;
        
//         eID.innerHTML = `Employee ID : ${form.employeeId}`;

//         formDiv.append(formID);
//         formDiv.append(firstNameHeader);
//         formDiv.append(lastNameHeader);
//         formDiv.append(timeForm);
//         formDiv.append(dateform);
//         formDiv.append(formDescription);
//         formDiv.append(formJustification);
//         formDiv.append(eventClassification);
//         formDiv.append(eID);
//     }

//     })
//     .catch((error) =>
//     {
//         console.log(error);
//     });
// }


async function viewAllEmployees() {


    let res = await fetch (
         `${baseUrl}/employeelogin/viewforms`,
         {
             method : 'GET',
             header : {'Content-Type': 'application/json'},
         }
     );
 
 
     let resJson = await res.json()
     .then((resp) => {
         console.log(resp);
 
         let formDiv = document.getElementById("forms");
 
     for(let form of resp)
     {
 
         let formID = document.createElement('h2');
         let firstNameHeader = document.createElement('h2');
         let lastNameHeader = document.createElement('h2');
         let dateform = document.createElement('h2');
         let timeForm = document.createElement('h2');
         let formDescription = document.createElement('h2');
         let formJustification = document.createElement('h2');
         let eventClassification = document.createElement('h2');
         let eID = document.createElement('h2');
 
         formID.innerHTML = `Form Identification Number : ${form.formId}`;
 
         firstNameHeader.innerHTML = form.eFirstName;
         firstNameHeader.className = "Classhere";
 
         lastNameHeader.innerHTML = form.eLastName;
         lastNameHeader.className = "lastName";
 
         dateform.innerHTML = `date : ${form.formDate}`;
 
        
         timeForm.innerHTML = `Time : ${form.formTime}`;
 
         formDescription.innerHTML = `Event Description : ${form.eventDescription}`;
         formJustification.innerHTML = `Event Justification : ${form.formJustification}`;
 
         eventClassification.innerHTML = `Type of Event : ${form.eventType}`;
         
         eID.innerHTML = `Employee ID : ${form.employeeId}`;
 
         formDiv.append(formID);
         formDiv.append(firstNameHeader);
         formDiv.append(lastNameHeader);
         formDiv.append(timeForm);
         formDiv.append(dateform);
         formDiv.append(formDescription);
         formDiv.append(formJustification);
         formDiv.append(eventClassification);
         formDiv.append(eID);
     }
 
     })
     .catch((error) =>
     {
         console.log(error);
     });
 
 
 }

 async function editForm() 
 {
    let formID = document.getElementById('fId').value;
    let efirst = document.getElementById('firstN').value;
    let elast = document.getElementById('lastName').value;
    let formD = document.getElementById('date').value;
    let eTime = document.getElementById('eventTime').value;
    let formLocation = document.getElementById('location').value;
    let eventT = document.getElementById('select').value;
    let eventC = document.getElementById('cost').value;
    let gradeT = document.getElementById('grading').value;
    let formJustif = document.getElementById('justification').value;
    let eventDesc = document.getElementById('eventDescription').value;
    
    let data = {
        formId : formID,
        eFirstName : efirst,
        eLastName : elast,
        formDate : formD,
        formTime : eTime,
        eventLocation : formLocation, 
        eventType : eventT,
        eventCost : eventC,
        gradeType : gradeT,
        formJustification : formJustif,
        eventDescription : eventDesc
    }

    console.log(data);

    let datajson = JSON.stringify(data);

    let res = await fetch(
    `${baseUrl}/employeelogin/editform`,
    {
        method : 'PUT',
        header : {'Content-Type' : 'application/json'},
        body : datajson
    }
    );

    console.log(res);

    let resJson = await res.json()
    .then((resp) => {
        console.log(resp);
        window.location.assign("employeehomepage.html");
    })
    .catch((error) =>
    {
        console.log(error);
    });
 }