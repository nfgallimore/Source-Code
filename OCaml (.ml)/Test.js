/**
 * track-houston.js
 * Created by nickgallimore on 8/24/15.
 */

var app = angular.module('track-houston', []);
app.controller("TrackHoustonCtrl", function ($scope)
{

    // dropdown other event controller

});
app.run([
    '$rootScope', function ($scope)
    {
        Parse.initialize("sD4tDFzNyuas8Vg0VhoXeF5OSnLHMkJRLxuHOkUL", "ntKIRdfzedSkLFGaj99qrC2lG2VNOXdWIrONcVIP");
        $scope.scenario = 'Log in';
        $scope.currentUser = Parse.User.current();
        $scope.createCoachSuccess = null;
        $scope.createStudentSuccess = null;
        $scope.newAcctType = null;
        $scope.isAdmin = false;
        $scope.isCoach = false;
        $scope.isStudent = false;
        $scope.runs = [{}];
        $scope.noitems = [];
        $scope.runsJSON = [];
        $scope.createAdminSuccess = null;
        //$scope.createEvent = function () {
        //    var newEvent = $("#event").val();
        //    if (newEvent == 0) {
        //        var element = document.createElement("input");
        //        //Create Labels
        //        var label = document.createElement("Label");
        //        label.innerHTML = "Other";
        //
        //        //Assign different attributes to the element.
        //        element.setAttribute("type", "text");
        //        element.setAttribute("value", "Replace with new event name.");
        //        element.setAttribute("name", "otherEvent");
        //        element.setAttribute("style", "width:200px");
        //
        //        label.setAttribute("style", "font-weight:normal");
        //
        //        // 'foobar' is the div id, where new fields are to be added
        //        var foo = document.getElementById("#event").parentNode;
        //
        //        //Append the element in page (in span).
        //        foo.appendChild(label);
        //        foo.appendChild(element);
        //        var txt = $("#otherEvent").val();
        //
        //        var o = new Option(txt, txt);
        //        /// jquerify the DOM object 'o' so we can use the html method
        //
        //        $(o).html(txt);
        //        $("#selectList").append(o);
        //    }
        //
        //};
        $scope.createAdmin = function ()
        {
            Parse.User.enableRevocableSession();
            var currUserToken = $scope.currentUser.getSessionToken();
            var admin = new Parse.User;
            admin.set("username", ($("#adminForm-fname").val().charAt(0) + $("#adminForm-lname").val()).toLowerCase());
            admin.set("password", "password");
            admin.set("type", "admin");
            admin.set("fname", $("#adminForm-fname").val().toLowerCase());
            admin.set("lname", $("#adminForm-lname").val().toLowerCase());
            var email = $("#adminForm-email").val();
            if (email.indexOf("@") > -1 || email.indexOf("." > -1))
            {
                $scope.createAdminSuccess = 'Invalid Email'
            }
            admin.set("email", email);
            admin.signUp(null, {
                success: function (admin)
                {
                    admin.save();
                    $scope.createAdminSuccess = 'Coach successfully created!';
                    $scope.$apply();
                    Parse.User.become(currUserToken, null).then(function (newUser)
                    {
                        // The current user is now set to user.
                    }, function (error)
                    {
                        // The token could not be validated.
                    });
                    console.log("Good news boss, I Successfully ran the function createCoach()!");
                },
                error: function (coach, error)
                {
                    alert("Unable to sign up:  " + error.code + " " + error.message);
                }
            })
        };
        $scope.createAccount = function (form)
        {
            var user = new Parse.User();
            user.set("email", form.email);
            user.set("username", form.username);
            user.set("password", form.password);
            //user.set("fname", $("#firstname").val());
            //user.set("lname", $("#lastname").val());
            //user.set("byear", $("#birthyear").val());
            //if (form.globalpassword.equals("trackhouston")) {
            user.signUp(null, {
                success: function (user)
                {
                    $scope.currentUser = user;
                    $scope.$apply();
                },
                error: function (user, error)
                {
                    alert("Unable to sign up:  " + error.code + " " + error.message);
                }
            });
            //}
        };
        $scope.logIn = function (form)
        {
            Parse.User.logIn(form.username, form.password, {
                success: function (user)
                {
                    $scope.currentUser = user;
                    $scope.updateType();
                    $scope.$apply();
                },
                error: function (user, error)
                {
                    alert("Unable to log in: " + error.code + " " + error.message);
                }
            });
        };
        $scope.logOut = function (form)
        {
            Parse.User.logOut();
            $scope.currentUser = null;
            $scope.isAdmin = false;
            $scope.isCoach = false;
            $scope.isStudent = false;
        };
        $scope.submitRunForm = function ()
        {
            var Run = Parse.Object.extend("Run");
            var run = new Run();
            var name = $("#name").val().toLowerCase();
            run.set("name", name);
            run.set("time", $("#time").val());
            run.set("event", $("#event").val());
            run.set("date", $("#datepicker1").val());
            var username = $scope.lookUpUsernameByName(name);
            var User = Parse.Object.extend("_User");
            var query = new Parse.Query(User);
            query.find({
                success: function (results)
                {
                    for (var i = 0; i < results.length; i++)
                    {
                        if ((results[i].get("fname") + " " + results[i].get("lname")) == ($("#name").val().toLowerCase()))
                        {
                            username = results[i].get("username");
                        }
                    }
                },
                error: function (user, error)
                {
                    alert("Unable to log in: " + error.code + " " + error.message);
                }
            });
            run.set("username", username);
            run.save(null, {
                success: function (run)
                {
                    run.save();
                    console.log("Successfully ran the function submitRunForm()!");
                }
            })
        };
        $scope.submitGradeForm = function ()
        {
            var Grade = Parse.Object.extend("Grade");
            var grade = new Grade();
            grade.set("name", $scope.currentUser.get("username"));
            console.log($scope.currentUser.get("username"));
            grade.set("grade1", $("#class1").val() + ": " + $("#grade1").val());
            grade.set("grade2", $("#class2").val() + ": " + $("#grade2").val());
            grade.set("grade3", $("#class3").val() + ": " + $("#grade3").val());
            grade.set("grade4", $("#class4").val() + ": " + $("#grade4").val());
            grade.set("grade5", $("#class5").val() + ": " + $("#grade5").val());

            grade.save(null, {
                success: function (grade)
                {
                    grade.save();
                    console.log("Successfully ran the function submitGradeForm()!");
                }
            })
        };
        $scope.createStudent = function ()
        {
            Parse.User.enableRevocableSession();
            var currUserToken = $scope.currentUser.getSessionToken();
            var student = new Parse.User;
            student.set("username", ($("#studentForm-fname").val().charAt(0) + $("#studentForm-lname").val()).toLowerCase());
            student.set("password", "password");
            student.set("fname", $("#studentForm-fname").val().toLowerCase());
            student.set("lname", $("#studentForm-lname").val().toLowerCase());
            student.set("pname", $("#studentForm-parentName").val().toLowerCase());
            student.set("byear", $("#studentForm-birthYear").val().toLowerCase());
            student.set("psite", $("#studentForm-practiceSite").val().toLowerCase());
            student.set("type", "student");
            student.signUp(null, {
                success: function (student)
                {
                    student.save();
                    $scope.createStudentSuccess = "Student successfully created!";
                    $scope.$apply();
                    Parse.User.become(currUserToken, null).then(function (newUser)
                    {
                        // The current user is now set to user.
                    }, function (error)
                    {
                        // The token could not be validated.
                    });
                    console.log("Good news boss, I Successfully ran the function createStudent()!");
                },
                error: function (student, error)
                {
                    alert("Unable to sign up:  " + error.code + " " + error.message);
                }
            });
        };
        $scope.createCoach = function ()
        {
            Parse.User.enableRevocableSession();
            var currUserToken = $scope.currentUser.getSessionToken();
            var coach = new Parse.User;
            coach.set("username", ($("#coachForm-fname").val().charAt(0) + $("#coachForm-lname").val()).toLowerCase());
            coach.set("password", "password");
            coach.set("type", "coach");
            coach.set("fname", $("#coachForm-fname").val().toLowerCase());
            coach.set("lname", $("#coachForm-lname").val().toLowerCase());
            coach.set("position", $("#coachForm-position").val().toLowerCase());
            coach.set("homesite", $("#coachForm-homesite").val().toLowerCase());
            var email = $("#coachForm-email").val();
            if (email.indexOf("@") > -1 || email.indexOf("." > -1))
            {
                $scope.createCoachSuccess = 'Invalid Email'
            }
            coach.set("email", email);
            coach.signUp(null, {
                success: function (coach)
                {
                    coach.save();
                    $scope.createCoachSuccess = 'Coach successfully created!';
                    $scope.$apply();
                    Parse.User.become(currUserToken, null).then(function (newUser)
                    {
                        // The current user is now set to user.
                    }, function (error)
                    {
                        // The token could not be validated.
                    });
                    console.log("Good news boss, I Successfully ran the function createCoach()!");
                },
                error: function (coach, error)
                {
                    alert("Unable to sign up:  " + error.code + " " + error.message);
                }
            })
        };
        $scope.lookUpNameByUsername = function (username)
        {
            var User = Parse.Object.extend("_User");
            var query = new Parse.Query(User);
            query.find({
                success: function (results)
                {
                    for (var i = 0; i < results.length; i++)
                    {
                        var usrname = results[i].get("username");
                        if (usrname === username)
                        {
                            var fname = results[i].get("fname");
                            var lname = results[i].get("lname");
                            var name = fname + " " + lname;
                            console.log(name);
                            return name;
                        }
                    }
                },
                error: function (results, error)
                {
                    alert("Unable to find name: " + error.code + " " + error.message);
                }
            })
        };
        $scope.lookUpUsernameByName = function (name)
        {
            var User = Parse.Object.extend("_User");
            var query = new Parse.Query(User);
            query.find({
                success: function (results)
                {
                    for (var i = 0; i < results.length; i++)
                    {
                        var fname = results[i].get("fname");
                        var lname = results[i].get("lname");
                        var n = fname + " " + lname;
                        if (n === name)
                        {
                            console.log(results[i].get("username"));
                            return results[i].get("username");
                        }
                    }
                },
                error: function (results, error)
                {
                    alert("Unable to find username: " + error.code + " " + error.message);
                }
            })
        };
        $scope.populateDropdown = function ()
        {
            var User = Parse.Object.extend("_User");
            var query = new Parse.Query(User);
            var namesArr = [];
            query.find({
                success: function (results)
                {
                    for (var i = 0; i < results.length; i++)
                    {
                        var fname = results[i].get("fname");
                        var lname = results[i].get("lname");
                        var name = fname + " " + lname;
                        var username = $scope.lookUpUsernameByName(name);
                        namesArr.push(name);
                        console.log(name);
                        (function ($)
                        {
                            $('#name').append($('<option>', {
                                value: username,
                                text: name
                            }));
                        })(jQuery);
                    }
                },
                error: function (results, error)
                {
                    alert("Unable to sign up:  " + error.code + " " + error.message);
                }
            });
            console.log(namesArr);
            for (var i = 0; i < namesArr.length; i++)
            {
                $('#name').append($('<option>', {
                    value: $scope.lookUpUsernameByName(namesArr[i]),
                    text: namesArr[i]
                }));
            }
        };
        $scope.createRunTable = function ()
        {
            var Run = Parse.Object.extend("Run");
            var query = new Parse.Query(Run);
            query.find({
                success: function (results)
                {
                    for (var i = 0; i < results.length; i++)
                    {
                        var object = results[i];
                        (function ($)
                        {
                            $('#rundata').append('<tr><td><a href=runs/' + object.get('username') + '>' + object.get('name') + '</a></td><td>' + object.get('time') + '</td><td>' + object.get('event') + '</td><td>' + object.get('date') + '</td></tr>');
                        })(jQuery);
                        var name = object.get('name');
                        var time = object.get('time');
                        var event = object.get('event');
                        var date = object.get('date');
                        var obj = {Name: name, Time: time, Event: event, Date: date};
                        $scope.runs.push(obj);
                        $scope.runsJSON.push(object.toJSON())
                    }
                    console.log($scope.runsJSON);
                },
                error: function (error)
                {
                    alert("Error: " + error.code + " " + error.message);
                }
            });
        };
        $scope.createGradeTable = function ()
        {
            var Grade = Parse.Object.extend("Grade");
            var query = new Parse.Query(Grade);
            query.find({
                success: function (results)
                {
                    for (var i = 0; i < results.length; i++)
                    {
                        var object = results[i];
                        (function ($)
                        {
                            $('#gradeData').append('<tr><td>' + object.get('name') + '</td><td>' + object.get('grade1') + '</td><td>' + object.get('grade2') + '</td><td>' + object.get('grade3') + '</td><td>' + object.get('grade4') + '</td><td>' + object.get('grade5') + '</td></tr>');
                        })(jQuery);
                    }
                },
                error: function (error)
                {
                    alert("Error: " + error.code + " " + error.message);
                }
            });
        };
        $scope.updateType = function ()
        {
            if ($scope.currentUser != null)
            {
                if ($scope.currentUser.attributes.type === "student")
                {
                    $scope.isStudent = true;
                }
                else if ($scope.currentUser.attributes.type === "coach")
                {
                    $scope.isCoach = true;
                }
                else if ($scope.currentUser.attributes.type == "admin")
                {
                    $scope.isAdmin = true;
                }
            }
        };
        $scope.updateType();
        $scope.newAcctTypeUpdate = function ()
        {
            if ($("#studentType")[0].checked)
            {
                $scope.newAcctType = "student";
            }
            if ($("#coachType")[0].checked)
            {
                $scope.newAcctType = "coach";
            }
            if ($("#adminType")[0].checked)
            {
                $scope.newAcctType = "admin";
            }
        };
        $scope.newAcctTypeUpdate();
        $scope.createRunTable();
        $scope.createGradeTable();
        $scope.populateDropdown();
        $scope.lookUpUsernameByName("john johnson");
        $scope.lookUpNameByUsername("jjohnson");
    }
]);