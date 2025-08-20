
module.exports = {
    setFile(name, int8array) {
        FOP_FILE_SETTER(name, int8array);
    },

    removeFile(name) {
        FOP_FILE_REMOVER(name);
    },

    clearFiles() {
        FOP_FILES_CLEARER();
    },

    transform(mainFileName) {
        FOP_TRANSFORMER();
        const result = FOP_RESULT;
        FOP_RESULT = undefined;
        return result;
    },
};
