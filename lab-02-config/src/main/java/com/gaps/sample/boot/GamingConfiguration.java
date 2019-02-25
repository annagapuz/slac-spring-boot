package com.gaps.sample.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("gaming")
public class GamingConfiguration {

    private boolean enabled;
    private List<String> systems;
    private Library library;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getSystems() {
        return systems;
    }

    public void setSystems(List<String> systems) {
        this.systems = systems;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public static class Library {
        private boolean online;
        private boolean physicalMedia;
        private int quantity;

        public boolean isOnline() {
            return online;
        }

        public void setOnline(boolean online) {
            this.online = online;
        }

        public boolean isPhysicalMedia() {
            return physicalMedia;
        }

        public void setPhysicalMedia(boolean physicalMedia) {
            this.physicalMedia = physicalMedia;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
