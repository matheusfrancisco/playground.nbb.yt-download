(ns yt.core
  (:require ["@distube/ytdl-core$default" :as ytdl]
            ["fs" :as fs]))

(defn -main []
  (.log js/console "Downloading...")

  (-> (ytdl "https://www.youtube.com/watch?v=rkZk3PFt_XE")
      (.on "progress" (fn [chunkSize, downloaded, total] 
                        (.log js/console "Downloading..." (Math/floor (* (/ downloaded total) 100)) "%" )))
      (.pipe  (fs/createWriteStream "test.mp3"))))


