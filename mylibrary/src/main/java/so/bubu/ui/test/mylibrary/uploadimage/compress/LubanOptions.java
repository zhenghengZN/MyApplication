package so.bubu.ui.test.mylibrary.uploadimage.compress;

import java.io.Serializable;

public class LubanOptions implements Serializable {
    /**
     * 压缩到的最大大小，单位B
     */
    private int maxSize;
    private int maxHeight;
    private int maxWidth;
    private int grade;

    private LubanOptions() {
    }

    public int getGrade() {
        if (grade == 0) {
            return Luban.THIRD_GEAR;
        }
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public static class Builder {
        private LubanOptions options;

        public Builder() {
            options = new LubanOptions();
        }

        public Builder setMaxSize(int maxSize) {
            options.setMaxSize(maxSize);
            return this;
        }

        public Builder setGrade(int grade) {
            options.setGrade(grade);
            return this;
        }

        public Builder setMaxHeight(int maxHeight) {
            options.setMaxHeight(maxHeight);
            return this;
        }

        public Builder setMaxWidth(int maxWidth) {
            options.setMaxWidth(maxWidth);
            return this;
        }

        public LubanOptions create() {
            return options;
        }
    }
}
