class CandyBoxes
  def self.remainingCandies (candies)
    while true
      candies.sort! { |a, b| a <=> b }
      break if candies[0] == candies[-1]
      candies[-1] -= candies[0]
    end

    candies[0]
  end
end
