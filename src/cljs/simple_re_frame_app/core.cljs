(ns simple-re-frame-app.core
  (:require
   [reagent.core :as reagent]
   [re-frame.core :as re-frame]
   [simple-re-frame-app.events :as events]
   [simple-re-frame-app.views :as views]
   [simple-re-frame-app.config :as config]))



(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
