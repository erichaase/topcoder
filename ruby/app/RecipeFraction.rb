class RecipeFraction
  def self.solution (recipe, ingredients)
    rh     = {}
    count1 = 0
    recipe.each do |i|
      n, t = i.split
      n = n.to_i

      rh[t] = n
      count1 += n
    end

    count2 = 0
    ingredients.each do |i|
      count2 += rh[i] if rh.has_key?(i)
    end

    count2.to_f / count1.to_f
  end
end
