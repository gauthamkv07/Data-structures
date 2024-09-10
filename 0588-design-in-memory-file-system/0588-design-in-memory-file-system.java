class FileSystem {

    class Dir {
        HashMap<String, Dir> dirs;
        HashMap<String, String> files;

        public Dir() {
            dirs = new HashMap<>();
            files = new HashMap<>();
        }
    }

    Dir root;
    String lastPath;

    public FileSystem() {
        root = new Dir();
        lastPath = "";
    }

    public Dir goToDir(String path) {
        Dir currDir = root;

        if (path.equals("/")) {
            lastPath = "";
            return root;
        }

        String[] splitPath = path.split("/");

        int n = splitPath.length;

        lastPath = splitPath[n - 1];

        for (int i = 1; i < n - 1; i++)
            currDir = currDir.dirs.get(splitPath[i]);

        return currDir;
    }

    public List<String> ls(String path) {
        Dir currDir = goToDir(path);

        List<String> files = new ArrayList<>();

        if (!lastPath.equals("") && currDir.files.containsKey(lastPath)) {
            files.add(lastPath);
            return files;
        }
        currDir = lastPath.equals("") ? currDir : currDir.dirs.get(lastPath);

        files.addAll(new ArrayList<>(currDir.dirs.keySet()));
        files.addAll(new ArrayList<>(currDir.files.keySet()));

        Collections.sort(files);
        return files;
    }

    public void mkdir(String path) {
        Dir currDir = root;

        String[] splitPath = path.split("/");

        int n = splitPath.length;

        for (int i = 1; i < n; i++) {
            if (!currDir.dirs.containsKey(splitPath[i]))
                currDir.dirs.put(splitPath[i], new Dir());
            currDir = currDir.dirs.get(splitPath[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        Dir currDir = goToDir(filePath);
        currDir.files.put(lastPath, currDir.files.getOrDefault(lastPath, "") + content);
    }

    public String readContentFromFile(String filePath) {
        Dir currDir = goToDir(filePath);
        return currDir.files.get(lastPath);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */