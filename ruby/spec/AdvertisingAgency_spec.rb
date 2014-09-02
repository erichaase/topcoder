name, json = init(__FILE__)

describe name do
  json.each_with_index do |data, i|
    it "test #{i}" do
      test(name, data)
    end
  end
end
