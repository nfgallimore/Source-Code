function submitRunForm() {
    Parse.initialize("sD4tDFzNyuas8Vg0VhoXeF5OSnLHMkJRLxuHOkUL", "ntKIRdfzedSkLFGaj99qrC2lG2VNOXdWIrONcVIP");
    var Run = Parse.Object.extend("Run");
    var run = new Run();
    run.set("name", $("#name").val());
    run.set("time", $("#time").val());
    run.set("event", $("#event").val());
    run.set("date", $("#date").val());
    run.save(null, {
        success: function(run) {
            run.save();
        }
    })
}