var backend = {
    toast: function (message,successCallback, failureCallback) {
        cordova.exec(successCallback, failureCallback, "Backend", "toast", [message]);
    },
    getImage: function (successCallback, failureCallback) {
        cordova.exec(successCallback, failureCallback, "Backend", "getImage", []);
    }
}
module.exports = backend;