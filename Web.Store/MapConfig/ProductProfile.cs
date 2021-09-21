using AutoMapper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Web.Store.Data.Entities;
using Web.Store.Models;

namespace Web.Store.MapConfig
{
    public class ProductProfile : Profile
    {
        public ProductProfile()
        {
            CreateMap<Product, ProductInfoVM>();
            CreateMap<ProductInfoVM, Product>();
        }
    }
}
