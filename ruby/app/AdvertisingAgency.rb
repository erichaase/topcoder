# AdvertisingAgency[http://community.topcoder.com/stat?c=problem_statement&pm=7558]

class AdvertisingAgency
  def self.numberOfRejections (requests)
    bb       = {}
    nRejects = 0

    requests.each do |request|
      if bb.has_key? (request)
        nRejects += 1
      else
        bb[request] = true
      end
    end

    return nRejects
  end
end
