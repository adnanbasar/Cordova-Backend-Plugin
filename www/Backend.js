var backend = {
    toast: function (successCallback, failureCallback) {
        cordova.exec(successCallback, failureCallback, "Backend", "toast", []);
    }
}
module.exports = backend;